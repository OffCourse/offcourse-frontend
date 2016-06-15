(ns offcourse.system.plumbing
  (:require [cljs.core.async :refer [chan merge mult tap]]))

(def channels
  (let [router-output   (chan)
        appstate-output (chan)
        api-output      (chan)
        ui-output       (chan)
        auth-output     (chan)
        ui-mult         (mult ui-output)
        api-mult        (mult api-output)
        auth-mult       (mult auth-output)
        appstate-mult   (mult appstate-output)
        appstate-input  (merge [router-output
                                (tap auth-mult (chan))
                                (tap ui-mult (chan))
                                (tap api-mult (chan))])
        api-input       (tap appstate-mult (chan))
        router-input    (tap appstate-mult (chan))
        auth-input      (tap ui-mult (chan))
        ui-input        (tap appstate-mult (chan))]

    {:api      {:input  api-input
                :output api-output}
     :router   {:output router-output
                :input  router-input}
     :auth     {:input  auth-input
                :output auth-output}
     :appstate {:input  appstate-input
                :output appstate-output}
     :ui       {:input  ui-input
                :output ui-output}}))
