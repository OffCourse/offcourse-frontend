(ns offcourse.appstate.redirect
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.views.helpers :as vh]))

(defn action [payload]
  {:type :requested-view
   :payload payload})

(defmulti redirect (fn [as destination & _] destination))

(defmethod redirect :home [as destination]
  (qa/refresh as (action (vh/home-view))))

(defmethod redirect :signup [as destination]
  (qa/refresh as (action (vh/signup-view))))

(defmethod redirect :course [as destination course]
  (qa/refresh as (action (vh/course-view course))))
