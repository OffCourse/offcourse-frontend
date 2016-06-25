(ns offcourse.models.response.to-payload
  (:require [offcourse.models.response.converters :as cv]
            [offcourse.models.payload.index :as payload]))

(defmulti to-payload (fn [{:keys [type]}] type))

(defmethod to-payload :user-profile [{:keys [type user-profile]}]
  (payload/new type (cv/to-user-profile user-profile)))

(defmethod to-payload :course [{:keys [type course]}]
  (payload/new type (cv/to-course course)))

(defmethod to-payload :courses [{:keys [type courses]}]
  (payload/new type (cv/to-courses courses)))

(defmethod to-payload :resources [{:keys [type resources]}]
  (payload/new type (cv/to-resources resources)))
