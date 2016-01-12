(ns offcourse.appstate.lifecycle
  (:require [offcourse.protocols.queryable :refer [check]]
            [offcourse.protocols.responsive :as ri]))

(defn start [as]
  (assoc as :listener (ri/listen as)))

(defn stop  [as]
  (dissoc as :listener))
