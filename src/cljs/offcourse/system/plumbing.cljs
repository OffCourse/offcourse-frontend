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
        courses-input       (tap data-service-mult (chan))
        resources-input     (tap data-service-mult (chan))
        renderer-input      (chan)]

    (pipe logger-output renderer-input)

    {:courses      {:input  courses-input
                    :log    logger-input
                    :output api-output}
     :resources    {:input  resources-input
                    :log    logger-input
                    :output api-output}
     :router       {:output router-output
                    :log    logger-input}
     :logger       {:input  logger-input
                    :output logger-output}
     :datastore    {:input  data-service-input
                    :log    logger-input
                    :output data-service-output}
     :appstate     {:input  appstate-input
                    :log    logger-input
                    :output appstate-output}
     :renderer     {:input renderer-input
                    :log   logger-input}}))
