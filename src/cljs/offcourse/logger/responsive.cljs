(ns offcourse.logger.responsive
  (:require [cljs.core.async :refer [<!]]
            [offcourse.models.action :as action]
            [offcourse.protocols.loggable :as la]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn listen [{:keys [log channels] :as component}]
  (assoc component :listener
         (go-loop []
           (when-let [action (<! (:input channels))]
             (swap! log #(conj % (la/log action)))
             (ri/respond component :updated-logs {:log (take 100 @log)})
             (recur)))))
