(ns offcourse.auth.fetch
  (:require [cljs.core.async :refer [<!]]
            [cuerdas.core :as str]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch (fn [user {:keys [type]}] type))

(defmethod fetch :token [auth {:keys [token]}]
  (go
    (ri/respond auth :signed-in-user :token token)))
