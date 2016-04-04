(ns offcourse.user.refresh
  (:require [cljsjs.aws-sdk-js]
            [cuerdas.core :as str]
            [offcourse.protocols.responsive :as ri]))

(defmulti refresh (fn [user {:keys [type]}] type))

(defmethod refresh :token [user {:keys [token]}]
  (when token
    (ri/respond user :refreshed-user :user {:name :yeehaa})))

(defmethod refresh :default [user _]
  (ri/respond user :refreshed-user :user {:name nil}))
