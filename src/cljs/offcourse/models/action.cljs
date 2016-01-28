(ns offcourse.models.action
  (:require [offcourse.protocols.loggable :refer [Loggable]]))

(defn- log [{:keys [type source payload]}]
  [(.getTime (js/Date.)) type source (when payload payload)])

(defrecord Action [type source payload]
  Loggable
  (log [this] (log this)))

(defn new [type source payload]
  (->Action type source payload))

