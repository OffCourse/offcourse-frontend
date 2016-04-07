(ns offcourse.cloud.fetch
  (:require [cljs.core.async :refer [<! chan >!]]
            [medley.core :as medley]
            [AWS]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)

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

(defn open-or-create-dataset []
  (let [c (chan)]
    (.openOrCreateDataset (AWS.CognitoSyncManager.) "user-data" #(go (>! c %2)))
    c))

(defn get-profile [dataset]
  (let [c (chan)]
    (.get dataset "profile" #(go (if %2
                                   (>! c %2)
                                   (println %1))))
    c))

(defn sync [dataset]
  (.synchronize dataset (clj->js {:onSuccess #(println "success")
                                  :onFailure #(println %1)
                                  :onConflict #(println "conflict")}))
  dataset)

(defn fetch [cloud query]
  (go
    ;; this is (obviously) a hack, probably beta problem...
    (<! (invoke-lambda "hello-world" {}))
    (let [dataset (sync (<! (open-or-create-dataset)))
          profile-json (<! (get-profile dataset))
          profile (parse-json profile-json)]
      (ri/respond cloud :fetched-user-profile
                  {:type :user :user profile}))))
