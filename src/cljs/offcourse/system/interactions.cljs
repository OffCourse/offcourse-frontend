(ns offcourse.system.interactions
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.renderable :as rr]))

(def actions
  {:api       [:failed-fetch
               :fetched-data]
   :logger    [:updated-logs]
   :router    [:requested-route]
   :appstate  [:updated-viewmodel]
   :datastore [:checked-store
               :not-found-data
               :refreshed-datastore]
   :ui        [:rendered-view]})

(def reactions
  {:api       {:not-found-data qa/fetch}
   :logger    {:logged-action println}
   :router    {:home-view       (fn []{:type       :collection-view
                                       :collection {:collection-type :flags
                                                    :collection-name :new}})
               :collection-view (fn [collection] {:type       :collection-view
                                                  :collection collection})
               :checkpoint-view (fn [data] {:type          :checkpoint-view
                                            :course        (select-keys data [:checkpoint-id :curator :hashtag])
                                            :checkpoint-id (:checkpoint-id data)})}

   :appstate  {:requested-route          qa/refresh
               :requested-new-checkpoint :forward
               :checked-store            qa/refresh
               :refreshed-datastore      qa/refresh}
   :datastore {:not-found-data           qa/check
               :requested-new-checkpoint qa/add
               :fetched-data             qa/refresh}
   :ui        {:composed-viewmodel rr/render
               :updated-logs       rr/render}})
