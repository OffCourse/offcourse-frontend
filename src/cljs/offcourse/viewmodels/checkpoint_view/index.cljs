(ns offcourse.viewmodels.checkpoint-view.index
  (:require [offcourse.models.course :as co :refer [Course]]
            [offcourse.models.label :as lb :refer [Label]]
            [offcourse.models.resource :refer [Resource]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [offcourse.viewmodels.checkpoint-view.validatable :as va-impl]
            [plumbing.core :refer-macros [fnk]]
            [plumbing.graph :as graph]
            [schema.core :as schema :include-macros true]))

(schema/defrecord CheckpointView
    [view-name :- Keyword
     labels :- {Keyword #{Label}}
     course :- Course
     checkpoint-id :- schema/Num
     resource :- (schema/maybe Resource)]
  Validatable
  (-missing-data [vm] (va-impl/missing-data vm))
  (-valid? [vm] (if (qa/check vm) false true))
  Queryable
  (-check [vm] (schema/check CheckpointView vm))
  (-refresh [vm store] #_(qa-impl/refresh vm store)))


(defn select-checkpoint [checkpoints selected-id]
  (for [{:keys [checkpoint-id] :as checkpoint} checkpoints]
    (if (= selected-id checkpoint-id)
      (with-meta checkpoint {:selected true})
      checkpoint)))

(defn augment-course [{:keys [checkpoints] :as course} checkpoint-id]
  (let [tags (-> (co/get-tags course)
                 (lb/collection->labels checkpoint-id))]
    (some-> course
            (assoc :checkpoints (select-checkpoint checkpoints checkpoint-id))
            (with-meta {:tags tags}))))

(def graph
  {:view-data     (fnk [appstate] (:view-data appstate))
   :view-name     (fnk [appstate] (:view-type appstate))
   :checkpoint-id (fnk [view-data]
                       (:checkpoint view-data))
   :course        (fnk [appstate view-data checkpoint-id]
                       (if-let [course (-> appstate
                                           (qa/get :course (:course view-data))
                                           (augment-course checkpoint-id))]
                         course
                         (:course view-data)))
   :tags          (fnk [course] (co/get-tags course))
   :labels        (fnk [tags] {:tags (lb/collection->labels tags)})
   :resource-id   (fnk [course checkpoint-id]
                       (co/get-resource-id course checkpoint-id))
   :resource      (fnk [appstate resource-id]
                       (qa/get appstate :resource {:resource-id resource-id}))})

(def compose (graph/compile graph))

(defn dummy [{:keys [checkpoint-id] :as data}]
  {:view-type :checkpoint-view
   :view-data {:type :course
               :course (select-keys data [:curator :hashtag])
               :checkpoint (or (int checkpoint-id) 0)}})

(defn new [appstate datastore]
  (-> {:appstate appstate}
      compose
      map->CheckpointView))
