(ns offcourse.system.interactions
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.renderable :as rr]
            [offcourse.protocols.authenticable :as ac]
            [offcourse.models.collection :as cl]))

(def actions
  {:api       [:not-found-data
               :found-data]
   :logger    [:updated-logs]
   :router    [:requested-route]
   :appstate  [:refreshed-state
               :checked-state
               :not-found-data]
   :user      [:signed-in-user]
   :ui        [:rendered-view
               :requested-sign-in]})

(def reactions
  {:api       {:not-found-data qa/fetch}
   :logger    {:logged-action println}
   :router    {}
   :appstate  {:requested-route          qa/refresh
               :found-data               qa/refresh
               :not-found-data           qa/check
               :signed-in-user           qa/refresh}
   :user      {:requested-sign-in        ac/authenticate}
   :ui        {:refreshed-state          rr/render
               :checked-state            rr/render
               :updated-logs             rr/render}})
