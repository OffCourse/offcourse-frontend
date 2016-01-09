(ns offcourse.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(defn channels []
  (let [user-output         (chan)
        api-input           (chan)
        api-output          (chan)
        data-service-input  (merge [user-output api-output])
        data-service-output (chan)
        data-service-mult   (mult data-service-output)
        renderer-input      (chan)]

    (tap data-service-mult api-input)
    (tap data-service-mult renderer-input)

    {:user-output         user-output
     :api-input           api-input
     :api-output          api-output
     :data-service-input  data-service-input
     :data-service-output data-service-output
     :renderer-input      renderer-input}))
