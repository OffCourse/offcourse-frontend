(ns offcourse.user.refresh
  (:require [cuerdas.core :as str]
            [offcourse.protocols.responsive :as ri]))

(defmulti refresh (fn [user {:keys [type]}] type))

(defmethod refresh :authenticated? [user {:keys [authenticated?]}]
  (if authenticated?
    (ri/respond user :refreshed-user :user {:name :yeehaa})
    (ri/respond user :refreshed-user :user {:name nil})))
