(ns offcourse.views.helpers)

(defn collection-view [collection]
  {:type    :collection-view
   :dependencies  {:collection collection}})

(defn checkpoint-view [{:keys [checkpoint-id] :as data}]
  {:type :checkpoint-view
   :dependencies {:course     (select-keys data [:curator :slug])
                  :checkpoint (or (int checkpoint-id) 0)}})

(defn new-course-view [{:keys [curator]}]
  {:type :course-view
   :dependencies {:course     {:course-id :new
                               :curator curator}}})
