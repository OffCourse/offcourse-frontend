(ns offcourse.system.interactions
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.renderable :as rr]
            [offcourse.models.collection :as cl]
            [offcourse.viewmodels.checkpoint-view.index :as cpvm]
            [offcourse.viewmodels.collection-view.index :as clvm]))

(def actions
  {:api       [:not-found-data
               :found-data]
   :logger    [:updated-logs]
   :router    [:requested-route]
   :appstate  [:refreshed-state
               :checked-state
               :not-found-data]
   :ui        [:rendered-view]})

(def reactions
  {:api       {:not-found-data qa/fetch}
   :logger    {:logged-action println}
   :router    {:crashed                  ri/restart}
   :appstate  {:requested-route          qa/refresh
               :found-data               qa/refresh
               :not-found-data           qa/check
               #_:checked-store            #_qa/check
               #_:refreshed-store          #_qa/check}
   :ui        {:refreshed-state          rr/render
               :checked-state            rr/render
               :updated-logs             rr/render}})
