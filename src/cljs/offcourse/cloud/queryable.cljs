(ns offcourse.cloud.queryable
  (:require [ajax.core :refer [POST]]
            [cljs.core.async :refer [<! chan]]
            [clojure.walk :as walk]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn handle-response [response]
  (let [{:keys [type error] :as response} (-> response
                                        walk/keywordize-keys)]
    (println response)
    (if-not error
      ((keyword type) response)
      {:error :not-found})))

(defn fetch-data [query]
  (let [c (chan)]
    (POST (str "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/staging/courses")
        {:headers {}
         :params (clj->js query)
         :format :json
         :handler #(go (>! c (handle-response %)))})
    c))

(defn fetch-1 [cloud {:keys [type] :as query} converter]
  (go
    (let [result (<! (fetch-data query))]
      (if (:error result)
        (ri/respond cloud :not-found-data query)
        (ri/respond cloud :found-data type (converter result))))))

(defn fetch-m [cloud {:keys [type] :as query} converter field]
  (go
    (let [result (<! (fetch-data query))]
      (if (or (:error result) (empty? result))
        (ri/respond cloud :not-found-data query)
        (when-let [converted (keep converter result)]
          (ri/respond cloud :found-data type converted))))))

(defn fetch [{:keys [fetchables] :as cloud} {:keys [type] :as query}]
  (when false #_(or (= type :courses) (= type :collection))
    (if-let [[converter field] (type fetchables)]
      (if field
        (fetch-m cloud query converter field)
        (fetch-1 cloud query converter))
      (ri/respond cloud :query-not-supported query))))
