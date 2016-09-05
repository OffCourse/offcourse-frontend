(ns offcourse.api.send
  (:require [cljs.core.async :refer [<!]]
            [cljs.core.match :refer-macros [match]]
            [shared.protocols.convertible :as cv]
            [shared.protocols.responsive :as ri]
            [shared.protocols.validatable :as va])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti send (fn [_ event] (second (va/resolve-type event))))


(defmethod send :query [{:keys [component-name repositories] :as api} [_ query :as event]]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources (va/resolve-type query))
      (go
        (let [response (<! (ri/send repository (into [component-name] event)))]
          (match response
                 [:fetched _]    (ri/respond api [:found (-> response cv/to-models)])
                 [:error _] (ri/respond api [:not-found query])
                 _ (ri/respond api [:failed query])))))))
