(ns offcourse.protocols.responsive
  (:require [cljs.core.async :refer [<! >! put! timeout]]
            [offcourse.models.action :as action])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defprotocol Responsive
  (listen [this])
  (respond [this status] [this status payload] [this status type result]))

(defn payload [type result]
  {:type type
   type result})

(defn first-run [{:keys [component-name actions reactions initialized?] :as component}]
  (when-not @initialized?
    (let [initial-response-type (keyword (str "initialized-" (name component-name)))
          responses actions
          actions (keys reactions)]
      #_(println "--------")
      #_(println initial-response-type)
      #_(println "actions:  " actions)
      #_(println "responses:" responses)
      (respond component initial-response-type [{:responses responses
                                                 :actions actions}])
      (swap! initialized? not))))

(defn -respond
  ([{:keys [output-channel component-name component-name]} status payload]
   (if output-channel
     (go (>! output-channel
           (action/new status component-name payload)))
     (action/new status component-name payload)))
  ([this status type result](-respond this status (payload type result))))

(defn -listen [{:keys [output-channel component-name input-channel reactions initialized?]
                :as this}]
  (go-loop []
    (first-run this)
    (let [{:keys [type source payload] :as action} (<! input-channel)
          reaction (type reactions)]
      (when (= component-name :appstate) (println type))
      (if reaction
        (reaction this payload)
        #_(do
          (println "--------")
          (println "component:    " component-name)
          (println "responseless: " source type)
          (println "valid actions:" (keys reactions))))
      (recur))))
