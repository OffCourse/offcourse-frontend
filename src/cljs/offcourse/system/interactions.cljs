(ns offcourse.system.interactions
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.composable :as ca]
            [offcourse.protocols.rendering :as rr]))

(def actions
  {:api       [:failed-fetch
               :fetched-data]
   :logger    [:updated-logs]
   :router    [:requested-route]
   :appstate  [:updated-viewmodel]
   :datastore [:checked-store
               :not-found-data
               :refreshed-datastore]
   :renderer  [:rendered-view]})

(def reactions
  {:api       {:not-found-data      qa/fetch}
   :logger    {:logged-action       println}
   :router    {:home-view           (partial merge {:type            :collection-view
                                                   :collection-type :flags
                                                   :collection-name :new})
               :collection-view     (partial merge {:type :collection-view})
               :course-view         (partial merge {:type :course-view})
               :checkpoint-view     (partial merge {:type :checkpoint-view})}
   :appstate  {:requested-route     qa/refresh
               :checked-store       ca/compose
               :refreshed-datastore ca/compose}
   :datastore {:not-found-data      qa/check
               :fetched-data        qa/refresh}
   :renderer  {:composed-viewmodel  rr/render
               :updated-logs        rr/render}})
