(ns offcourse.views.collection
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [plumbing.core :refer-macros [fnk]]))

(defn augment-course [selected {:keys [checkpoints] :as course}]
  (let [tags (-> (co/get-tags course)
                 (lb/collection->labels selected))]
    (-> course (with-meta {:tags tags}))))

(def graph
  {:collection-data (fnk [view-data]
                         (:collection view-data))
   :collection      (fnk [appstate collection-data]
                         (or (qa/get appstate :collection collection-data)
                             collection-data))
   :courses         (fnk [appstate collection]
                         (some->> (qa/get appstate :courses (:course-ids collection))
                                  (map (partial augment-course (:collection-name collection)))))
   :main            (fnk [courses url-helpers [:components cards]]
                         (cards courses url-helpers))})
