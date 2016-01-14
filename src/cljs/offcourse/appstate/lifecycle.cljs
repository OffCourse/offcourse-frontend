(ns offcourse.appstate.lifecycle
  (:require [offcourse.protocols.queryable :refer [check]]
            [offcourse.protocols.responsive :as ri]))

(defn start [as viewmodels]
  (let [as (assoc as :viewmodels viewmodels
                  :proposed (atom nil)
                  :current (atom nil))]
    (assoc as :listener (ri/listen as))))


(defn stop  [as]
  (dissoc as :listener :proposed :current))
