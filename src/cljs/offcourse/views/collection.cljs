(ns offcourse.views.collection
  (:require [offcourse.protocols.decoratable :as dc]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:collection-data (fnk [view-data]
                         (:collection view-data))
   :collection      (fnk [appstate collection-data]
                         (or (qa/get appstate :collection collection-data)
                             collection-data))
   :courses         (fnk [appstate user-name collection]
                         (let [course-ids (map (fn [id] {:course-id id}) (:course-ids collection))]
                           (some->> (qa/get appstate :courses course-ids)
                                    (map #(dc/decorate %1 user-name (:collection-name collection))))))
   :actions   (fnk [user-name [:url-helpers home-url new-course-url]]
                   {:add-course (when user-name (new-course-url user-name))})
   :main            (fnk [courses url-helpers handlers [:components cards]]
                         (cards courses url-helpers handlers))})
