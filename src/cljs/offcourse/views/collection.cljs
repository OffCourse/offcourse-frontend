(ns offcourse.views.collection
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn augment-course [selected user-name {:keys [curator checkpoints] :as course}]
  (let [tags (-> (qa/get course :tags {})
                 (lb/collection->labels selected))]
    (some-> course
            (with-meta {:tags tags
                        :trackable? (= user-name curator)}))))

(def graph
  {:collection-data (fnk [view-data]
                         (:collection view-data))
   :collection      (fnk [appstate collection-data]
                         (or (qa/get appstate :collection collection-data)
                             collection-data))
   :courses         (fnk [appstate user-name collection]
                         (let [course-ids (map (fn [id] {:course-id id}) (:course-ids collection))]
                           (some->> (qa/get appstate :courses course-ids)
                                    (map (partial augment-course (:collection-name collection) user-name)))))
   :actions   (fnk [user-name [:url-helpers home-url new-course-url]]
                   {:add-course (when user-name (new-course-url user-name))})
   :main            (fnk [courses url-helpers handlers [:components cards]]
                         (cards courses url-helpers handlers))})
