(ns offcourse.views.helpers)

(defn collection-view [collection]
  {:type    :collection-view
   :dependencies  {:collection collection}})

(defn checkpoint-view [{:keys [checkpoint-id] :as data}]
  {:type :checkpoint-view
   :dependencies {:course     (select-keys data [:curator :course-slug])
                  :checkpoint (select-keys data [:checkpoint-slug :checkpoint-id])}})

(defn new-course-view [{:keys [curator]}]
  {:type :course-view
   :dependencies {:course     {:course-id :new
                               :curator curator}}})
