(ns offcourse.views.new-user
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [plumbing.core :refer-macros [fnk]]))


(defn augment-profile [profile]
  (let [valid? (va/valid? profile)]
    (println valid?)
    (-> profile (with-meta {:valid? valid?}))))

(def graph
  {:profile     (fnk [appstate] (some-> (:viewmodel appstate)
                                        (qa/get :profile {})
                                        augment-profile))
   :main        (fnk [] nil)
   :actions     (fnk [] nil)
   :dashboard   (fnk [profile [:components dashboard user-form] handlers]
                     (dashboard {:main (user-form profile handlers)}))})
