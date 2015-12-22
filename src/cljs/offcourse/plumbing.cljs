(ns offcourse.plumbing
  (:require [cljs.core.async :refer [pipe chan]]))

(defn channels []
  (let [api-input (chan)
        api-output (chan)
        view-input (chan)]

    (pipe api-output view-input)

    {:api-input api-input
     :api-output api-output
     :view-input view-input}))
