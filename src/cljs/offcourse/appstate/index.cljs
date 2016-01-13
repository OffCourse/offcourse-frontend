(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.lifecycle :as lc]
            [offcourse.models.collection-viewmodel :as clvm]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [medley.core :as medley]
            [offcourse.protocols.validatable :as va :refer [Validatable]]))

(def actions [:updated-viewmodel])

(def reactions {:requested-route qa/check
                :checked-store qa/refresh
                :refreshed-datastore qa/refresh})

(def viewmodels {:collection clvm/new})


(defn payload [type collection]
  (let [payload {:type type}]
    (case type
      :labels     (assoc payload :type :collection-names)
      :collection (assoc payload :collection (dissoc collection :course-ids))
      :courses    (assoc payload :course-ids (:course-ids collection)))))

(defn respond-not-found [{:keys [proposed] :as as}]
  (let [{:keys [collection]} @proposed
        next-field   (first (keys (qa/check @proposed)))]
    (ri/respond as :not-found-data (payload next-field collection))))

(defrecord Appstate [component-name input-channel output-channel actions reactions initialized?]
  Lifecycle
  (start [as] (lc/start as))
  (stop [as] (lc/stop as))
  Queryable
  (check [{:keys [proposed] :as as} {:keys [type] :as query}]
    (reset! proposed ((type viewmodels) query))
    (respond-not-found as))
  (refresh [{:keys [proposed] :as as} {:keys [store]}]
    (swap! proposed #(qa/refresh % store))
    (println (qa/check @proposed))
    (if (va/valid? @proposed)
      (ri/respond as :updated-viewmodel {:proposed-viewmodel @proposed})
      (respond-not-found as)))
  Responsive
  (respond [as status payload] (ri/-respond as status payload))
  (listen [as] (ri/-listen as)))

(defn new []
  (map->Appstate {:component-name :appstate
                  :actions actions
                  :reactions reactions
                  :initialized? (atom false)}))
