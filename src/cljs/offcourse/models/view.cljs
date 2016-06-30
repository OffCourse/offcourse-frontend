(ns offcourse.models.view
  (:require [offcourse.protocols.composable :as ca :refer [Composable]]
            [offcourse.protocols.mountable :as ma :refer [Mountable]]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [plumbing.graph :as graph]
            [rum.core :as rum]
            [offcourse.protocols.queryable :as qa]))

(defrecord View []
  Composable
  (-compose [view views]
    (assoc view :composition
           ((graph/compile ((:type view) views)) view)))
  Renderable
  (-render [{:keys [composition] :as view}]
    (assoc view :rendered
           ((:container composition) composition)))
  Mountable
  (-mount [{:keys [rendered]} element]
    (rum/mount rendered (. js/document (querySelector element)))))

(defn new [appstate components url-helpers handlers]
  (let [view-type (get-in appstate [:viewmodel :type])
        blacklist [:collection-data :tags :resource-id :course-ids :view-data]]
    (map->View {:appstate    appstate
                :type        view-type
                :components  components
                :handlers    handlers
                :url-helpers url-helpers})))
