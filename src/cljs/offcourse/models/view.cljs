(ns offcourse.models.view
  (:require [offcourse.protocols.composable :as ca :refer [Composable]]
            [offcourse.protocols.mountable :as ma :refer [Mountable]]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [plumbing.graph :as graph]
            [rum.core :as rum]
            [schema.core :as schema]))

(schema/defrecord View
    [type :- schema/Keyword
     viewmodel :- {}
     route-helpers :- {}
     handlers :- {}]
  Validatable
  (valid? [{:keys [viewmodel]}] (va/valid? viewmodel))
  (missing-data [{:keys [viewmodel]}] (va/missing-data viewmodel))
  Composable
  (-compose [view views]
    (assoc view :composition ((graph/compile ((:view-name viewmodel) views)) view)))
  Renderable
  (-render [{:keys [composition] :as view}]
    (assoc view :rendered ((:container composition) composition)))
  Mountable
  (-mount [{:keys [rendered]} element] (rum/mount rendered (. js/document (querySelector element)))))

(defn new [appstate datastore route-helpers viewmodels handlers]
  (let [view-type   (get-in appstate [:view :type])
        constructor (view-type viewmodels)
        blacklist   [:collection-data :tags :resource-id :course-ids :view-data]
        viewmodel   (constructor appstate datastore)]
    (map->View {:type          view-type
                :viewmodel     (apply dissoc viewmodel blacklist)
                :route-helpers route-helpers
                :handlers      handlers})))
