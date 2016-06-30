(ns offcourse.adapters.aws.queryable
  (:require [ajax.core :refer [POST]]
            [cljs.core.async :refer [chan]]
            [cljs.core.match :refer-macros [match]]
            [offcourse.models.response.index :as response])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn handle-response [res]
    (match res
           {"errorMessage" _} {:error :fetch-error}
           {"type" "found-data" "payload" payload} (response/new payload)
           {"type" "not-found-data" "payload" payload} {:error :not-found-data
                                                        :payload payload}))

(defn fetch [{:keys [endpoint]} {:keys [auth-token] :as query}]
  (let [c (chan)]
    (POST endpoint
        {:headers {:Authorization (str "Bearer " auth-token)}
         :params (clj->js query)
         :format :json
         :handler #(go (>! c (handle-response %)))})
    c))
