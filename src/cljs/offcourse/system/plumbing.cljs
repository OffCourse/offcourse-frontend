(ns offcourse.system.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(def channels
  (let [router-output       (chan)
        logger-input        (chan)
        logger-output       (chan)
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
        api-input           (tap data-service-mult (chan))
        ui-output           (chan)
        ui-input            #_logger-output (tap appstate-mult (chan))]

    {:api       {:input  api-input
                 :log    logger-input
                 :output api-output}
     :router    {:output router-output
                 :log    logger-input}
     :logger    {:input  logger-input
                 :output logger-output}
     :datastore {:input  data-service-input
                 :log    logger-input
                 :output data-service-output}
     :appstate  {:input  appstate-input
                 :log    logger-input
                 :output appstate-output}
     :ui        {:input ui-input
                 :output ui-output
                 :log   logger-input}}))
