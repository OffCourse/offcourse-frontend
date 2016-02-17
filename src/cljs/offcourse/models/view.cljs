(ns offcourse.models.view
  (:require [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [schema.core :as schema]))

(schema/defrecord View
    [container :- schema/Any
     components :- {schema/Keyword schema/Any}]
  Renderable
  (-render [{:keys [container components] :as view}]
    (container components)))

(defn new [container components]
  (map->View {:container container
              :components components}))
