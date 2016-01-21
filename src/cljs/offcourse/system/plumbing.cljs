(ns offcourse.system.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(defn channels []
  (let [router-output       (chan)
        appstate-output     (chan)
        data-service-output (chan)
        api-output          (chan)
        appstate-mult       (mult appstate-output)
        api-mult            (mult api-output)
        data-service-mult   (mult data-service-output)
        appstate-input      (merge [router-output
                                    (tap data-service-mult (chan))])
        data-service-input  (merge [(tap appstate-mult (chan))
                                    (tap api-mult (chan))])
        courses-input       (tap data-service-mult (chan))
        user-courses-input  (tap data-service-mult (chan))
        resources-input     (tap data-service-mult (chan))
        renderer-input      (chan)]

    (tap appstate-mult renderer-input)

    {:router-output         router-output
     :user-courses-input  user-courses-input
     :resources-input     resources-input
     :courses-input       courses-input
     :api-output          api-output
     :data-service-input  data-service-input
     :data-service-output data-service-output
     :appstate-input      appstate-input
     :appstate-output     appstate-output
     :renderer-input      renderer-input}))
