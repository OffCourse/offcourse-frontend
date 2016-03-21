(ns offcourse.appstate.add
  (:require [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defn add [{:keys [state] :as as} query]
  (let [course (-> (:viewmodel @state)
                   (qa/get query)
                   co/complete)]
    (if (va/valid? course)
      (qa/refresh as :course course)
      (.alert js/window "not saved..."))))
