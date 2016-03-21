(ns offcourse.appstate.add
  (:require [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defmulti add (fn [_ {:keys [type] :as query}] type))

(defmethod add :query [{:keys [state] :as as}
                       {:keys [missing-data] :as query}]
  (swap! state (fn [state] (update state :queries #(conj % (hash missing-data))))))

(defmethod add :course [{:keys [state] :as as} query]
  (let [course (-> (:viewmodel @state)
                   (qa/get query)
                   co/complete)]
    (if (va/valid? course)
      (qa/refresh as :course course)
      (.alert js/window "not saved..."))))
