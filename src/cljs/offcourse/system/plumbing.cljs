(ns offcourse.system.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(def channels
  (let [router-output   (chan)
        logger-input    (chan)
        logger-output   (chan)
        appstate-output (chan)
        api-output      (chan)
        ui-output       (chan)
        ui-mult         (mult ui-output)
        api-mult        (mult api-output)
        auth-output     (chan)
        appstate-mult   (mult appstate-output)
        appstate-input  (merge [router-output
                                auth-output
                                (tap ui-mult (chan))
                                (tap api-mult (chan))])
        api-input       (tap appstate-mult (chan))
        router-input    (tap appstate-mult (chan))
        auth-input      (tap ui-mult (chan))
        ui-input        #_logger-output (tap appstate-mult (chan))]

    {:api      {:input  api-input
                :log    logger-input
                :output api-output}
     :router   {:output router-output
                :input  router-input
                :log    logger-input}
     :logger   {:input  logger-input
                :output logger-output}
     :auth     {:input  auth-input
                :log    auth-input
                :output auth-output}
     :appstate {:input  appstate-input
                :log    logger-input
                :output appstate-output}
     :ui       {:input  ui-input
                :output ui-output
                :log    logger-input}}))
