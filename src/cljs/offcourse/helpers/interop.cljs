(ns offcourse.helpers.interop
  (:require [cljs.core.async :refer [<! chan put! take!]]))

(defn jsx->clj
  [x]
  (into {} (for [k (.keys js/Object x)] [(keyword k) (aget x k)])))

(defn handle-error [message]
  (let [error (jsx->clj message)]
    {:error error}))

(defn handle-promise
  ([promise]
   (handle-promise promise identity))
  ([promise cb]
   (let [channel (chan)]
     (-> promise
         (.then #(put! channel (cb %1)))
         (.catch #(put! channel (handle-error %1))))
     channel)))

(defn handle-json-response
  ([promise] (handle-promise promise js->clj))
  ([promise cb] (handle-promise promise (comp cb js->clj))))
