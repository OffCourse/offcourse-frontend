(ns offcourse.views.helpers)

(defn home-view []
  {:type    :collection-view
   :collection {:collection-type :flags
                :collection-name :featured}})

(defn collection-view [collection]
  {:type    :collection-view
   :collection collection})

(defn checkpoint-view [{:keys [checkpoint-id] :as data}]
  {:type :checkpoint-view
   :course     (select-keys data [:curator :course-slug])
   :checkpoint (select-keys data [:checkpoint-slug :checkpoint-id])})

(defn new-course-view [{:keys [curator]}]
  {:type :new-course-view
   :dependencies {:course     {:course-id :new
                               :curator curator}}})
