(ns offcourse.adapters.aws.queryable
  (:require [ajax.core :refer [POST]]
            [cljs.core.async :refer [chan]]
            [cljs.core.match :refer-macros [match]]
            [clojure.walk :as walk]
            [offcourse.models.payload.index :as pl])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn handle-response [res]
  (let [response (-> res
                     walk/keywordize-keys
                     (update-in [:type] #(keyword %))
                     (update-in [:payload :type] #(keyword %)))]
    (match response
           {:errorMessage _} {:error :fetch-error}
           {:type :found-data :payload payload} (pl/map->Payload payload)
           {:type :not-found-data} {:error :not-found-data})))

(defn fetch [{:keys [endpoint]} {:keys [auth-token] :as query}]
  (let [c (chan)]
    (POST endpoint
        {:headers {:Authorization (str "Bearer " auth-token)}
         :params (clj->js query)
         :format :json
         :handler #(go (>! c (handle-response %)))})
    c))
