(ns offcourse.api.lifecycle
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.protocols.bootstrappable :as ba]
            [com.stuartsierra.component :as lc]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn connect-to-repository [{:keys [adapter name fetchables supported-types]}]
  (lc/start (adapter name supported-types)))

(defn start [api]
  (let [api (update-in api [:repositories] #(map connect-to-repository %))]
    (assoc api :listener (ri/listen api))))

(defn stop [{:keys [input-channel] :as api}]
  (do
    (close! input-channel)
    (dissoc api :listener)))
