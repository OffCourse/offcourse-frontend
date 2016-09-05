(ns offcourse.adapters.aws.send
  (:require [ajax.core :refer [POST]]
            [cljs.core.async :refer [chan]]
            [shared.models.event.index :as event])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn handle-response [name res]
  (let [{:keys [type payload]} (js->clj (.parse js/JSON res) :keywordize-keys true)]
    (event/create [name (keyword type) payload])))

(defn send [{:keys [name endpoint]} [_ query :as event]]
  (let [c (chan)
        auth-token ""]
    (POST endpoint
        {:headers {:Authorization (str "Bearer " auth-token)}
         :params (clj->js {:type :request-data
                           :payload query})
         :format :json
         :handler #(go (>! c (handle-response name %)))})
    c))
