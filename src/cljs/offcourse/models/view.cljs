(ns offcourse.models.view
  (:require [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [plumbing.graph :as graph]
            [schema.core :as schema]))

(schema/defrecord View
    [container   :- schema/Any
     dashboard   :- schema/Any
     dashboard-main :- schema/Any
     logo           :- schema/Any
     actions        :- schema/Any
     main           :- schema/Any
     colorful       :- schema/Any
     nav            :- schema/Any]
  Renderable
  (-render [view] ((:container view) view)))

(defn compose [{:keys [view-name] :as viewmodel} views]
  ((graph/compile (view-name views)) viewmodel))

(defn new [viewmodel route-helpers handlers views]
  (let [view-data (-> viewmodel
                      (assoc :route-helpers route-helpers
                             :handlers handlers)
                      (compose views))]
    (map->View view-data)))
