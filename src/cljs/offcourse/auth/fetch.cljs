(ns offcourse.auth.fetch
  (:require [cljs.core.async :refer [<!]]
            [cuerdas.core :as str]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch (fn [user {:keys [type]}] type))

(defmethod fetch :profile [auth {:keys [token]}]
  (go
    (let [profile (<! (qa/get auth {:type :profile}))]
      (ri/respond auth :fetched-profile :profile (assoc profile :token token)))))
