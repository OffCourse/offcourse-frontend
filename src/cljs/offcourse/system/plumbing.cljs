(ns offcourse.system.plumbing
  (:require [cljs.core.async :refer [pipe pipeline merge mult tap chan]]))

(def channels
  (let [router-output       (chan)
        logger-input        (chan)
        logger-output       (chan)
        data-service-output (chan)
        api-output          (chan)
        ui-output           (chan)
        api-mult            (mult api-output)
        data-service-mult   (mult data-service-output)
        data-service-input  (merge [ui-output router-output
                                    (tap api-mult (chan))])
        api-input           (tap data-service-mult (chan))
        router-input        (tap data-service-mult (chan))
        ui-input            #_logger-output (tap data-service-mult (chan))]

    {:api       {:input  api-input
                 :log    logger-input
                 :output api-output}
     :router    {:output router-output
                 :input  router-input
                 :log    logger-input}
     :logger    {:input  logger-input
                 :output logger-output}
     :datastore {:input  data-service-input
                 :log    logger-input
                 :output data-service-output}
     :ui        {:input ui-input
                 :output ui-output
                 :log   logger-input}}))
