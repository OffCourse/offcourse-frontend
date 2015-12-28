(ns offcourse.helpers.interop
  (:require [cljs.core.async :refer [<! chan put!]]))

(defn jsx->clj
  [x]
  (into {} (for [k (.keys js/Object x)] [(keyword k) (aget x k)])))

(defn handle-js [json]
  (js->clj json :keywordize-keys true))

(defn handle-error [message]
  {:error (jsx->clj message)})

(defn handle-promise
  ([promise]
   (handle-promise promise identity))
  ([promise cb]
   (let [channel (chan)]
     (-> promise
         (.then #(put! channel (cb %1)))
         (.catch #(put! channel (handle-error %1))))
     channel)))

(defn handle-js-response
  ([promise] (handle-promise promise handle-js))
  ([promise cb] (handle-promise promise (comp cb handle-js))))
