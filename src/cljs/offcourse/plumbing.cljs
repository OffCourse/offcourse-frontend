(ns offcourse.plumbing
  (:require [cljs.core.async :refer [pipe chan]]))

(defn channels []
  (let [api-input (chan)
        api-output (chan)
        renderer-input (chan)]

    (pipe api-output renderer-input)

    {:api-input api-input
     :api-output api-output
     :renderer-input renderer-input}))
