(ns offcourse.user.refresh
  (:require [cljsjs.aws-sdk-js]
            [cuerdas.core :as str]
            [offcourse.protocols.responsive :as ri]))

(defmulti refresh (fn [user {:keys [type]}] type))

(defmethod refresh :profile [user {:keys [profile]}]
  (if-let [user-name (keyword (str/slugify (:name profile)))]
    (ri/respond user :refreshed-user :user {:name user-name})
    (ri/respond user :refreshed-user :user {:name nil})))
