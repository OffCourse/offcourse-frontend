(ns offcourse.auth.get
  (:require [cljs.core.async :refer [>! chan]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn get-status []
  (let [c (chan)]
    (.getLoginStatus js/FB #(go (>! c (js->clj % :keywordize-keys true))))
    c))

(defn get-profile []
  (let [c (chan)]
    (.api js/FB "/me" #(go (>! c (js->clj % :keywordize-keys true))))
    c))

