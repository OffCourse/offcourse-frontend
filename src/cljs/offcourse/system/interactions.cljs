(ns offcourse.system.interactions
  (:require [offcourse.protocols.queryable :as qa]
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
               :course-view     (fn [course]     {:type :course-view
                                                  :course course})
               :checkpoint-view (fn [data] {:type :checkpoint-view
                                            :course (select-keys data [:checkpoint-id :curator :hashtag])
                                            :checkpoint-id (:checkpoint-id data)})}

   :appstate  {:requested-route     qa/refresh
               :checked-store       qa/refresh
               :refreshed-datastore qa/refresh}
   :datastore {:not-found-data qa/check
               :fetched-data   qa/refresh}
   :ui        {:composed-viewmodel rr/render
               :updated-logs       rr/render}})
