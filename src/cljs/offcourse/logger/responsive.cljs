(ns offcourse.logger.responsive
  (:require [cljs.core.async :refer [<!]]
            [offcourse.models.action :as action]
            [offcourse.protocols.loggable :as la]
            [offcourse.protocols.responsive :as ri]
            [offcourse.views.log-table :as debug])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn listen [{:keys [log channels] :as component}]
  (assoc component :listener
         (go-loop []
           (when-let [action (<! (:input channels))]
             (swap! log #(conj % (la/log action)))
             (ri/respond component :updated-logs {:data (take 100 @log)
                                                  :view-component debug/debugger})
             (recur)))))
