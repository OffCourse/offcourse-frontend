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
               :not-found-data]
   :datastore [:checked-store
               :not-found-data
               :refreshed-store]
   :ui        [:rendered-view]})

(def reactions
  {:api       {:not-found-data qa/fetch}
   :logger    {:logged-action println}
   :router    {:home-view       (fn [] (clvm/dummy (cl/new :flags :new)))
               :collection-view (fn [data] (clvm/dummy data))
               :checkpoint-view (fn [data] (cpvm/dummy data))}
   :appstate  {:requested-route          qa/refresh
               :requested-new-checkpoint :forward
               :not-found-data           qa/check
               :checked-store            qa/check
               :refreshed-store          qa/check}
   :datastore {:not-found-data           qa/check
               :requested-new-checkpoint qa/add
               :found-data               qa/refresh}
   :ui        {:refreshed-appstate rr/render
               :checked-appstate rr/render
               :updated-logs       rr/render}})
