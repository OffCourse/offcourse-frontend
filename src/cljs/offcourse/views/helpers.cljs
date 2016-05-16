(ns offcourse.views.helpers)

(defn home-view []
  {:type    :collection
   :collection {:collection-type :flags
                :collection-name :featured}})

(defn collection-view [collection]
  {:type    :collection
   :collection collection})

(defn checkpoint-view [data]
  {:type :checkpoint
   :course     (select-keys data [:curator :course-slug])
   :checkpoint (select-keys data [:checkpoint-slug :checkpoint-id])})

(defn course-view [data]
  {:type :course
   :course     (select-keys data [:curator :course-slug])})

(defn new-course-view [{:keys [curator]}]
  {:type :new-course
   :dependencies {:course     {:course-id :new
                               :curator curator}}})
