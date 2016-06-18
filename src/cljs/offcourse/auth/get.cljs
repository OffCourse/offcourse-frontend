(ns offcourse.auth.get
  (:refer-clojure :exclude [get])
  (:require [cljs.core.async :refer [>! chan]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :auth-token [_ _]
  (.getItem js/localStorage "auth-token"))

