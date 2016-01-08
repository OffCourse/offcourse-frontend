(ns offcourse.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(defn channels []
  (let [user-output      (chan)
        api-input        (chan)
        api-output       (chan)
        datastore-input  (merge [user-output api-output])
        datastore-output (chan)
        datastore-mult   (mult datastore-output)
        renderer-input   (chan)]

    (tap datastore-mult api-input)
    (tap datastore-mult renderer-input)

    {:user-output      user-output
     :api-input        api-input
     :api-output       api-output
     :datastore-input  datastore-input
     :datastore-output datastore-output
     :renderer-input   renderer-input}))
