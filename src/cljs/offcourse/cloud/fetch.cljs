(ns offcourse.cloud.fetch
  (:require [cljs.core.async :refer [<! chan >!]]
            cljsjs.aws-sdk-js
            [medley.core :as medley]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn parse-json [payload]
  (->> payload
       (.parse js/JSON)
       js->clj
       (medley/map-kv (fn [key value][(keyword key)(keyword value)]))))

(defn convert-payload [response]
  (-> response
      (js->clj :keywordize-keys true)
      :Payload
      parse-json))

(defn invoke-lambda [function-name payload]
  (let [c (chan)]
    (.makeRequest (AWS.Lambda.) "invoke"
                  (clj->js {:FunctionName function-name
                            :Payload (.stringify js/JSON (clj->js payload))})
                  #(go (>! c (convert-payload %2))))
    c))

(defn fetch [cloud query]
  (go
    (let [user (<! (invoke-lambda "hello-world" {}))]
      (ri/respond cloud :refreshed-user {:type :user
                                         :user user}))))
