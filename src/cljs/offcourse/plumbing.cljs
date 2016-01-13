(ns offcourse.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(defn channels []
  (let [user-output         (chan)
        appstate-output     (chan)
        data-service-output (chan)
        api-output          (chan)
        appstate-mult       (mult appstate-output)
        api-mult            (mult api-output)
        data-service-mult   (mult data-service-output)
        appstate-input      (merge [#_user-output
                                    #_(tap data-service-mult (chan))])
        data-service-input  (merge [user-output
                                    (tap appstate-mult (chan))
                                    (tap api-mult (chan))])
        api-input           (tap data-service-mult (chan))
        renderer-input      (chan)]

    (tap data-service-mult renderer-input)

    {:user-output         user-output
     :api-input           api-input
     :api-output          api-output
     :data-service-input  data-service-input
     :data-service-output data-service-output
     :appstate-input      appstate-input
     :appstate-output     appstate-output
     :renderer-input      renderer-input}))
