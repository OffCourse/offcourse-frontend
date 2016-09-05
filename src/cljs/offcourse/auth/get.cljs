(ns offcourse.auth.get
  (:refer-clojure :exclude [get])
  (:require [cljs.core.async :refer [>! chan]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn get-local-token [_ _] (.getItem js/localStorage "auth-token"))
