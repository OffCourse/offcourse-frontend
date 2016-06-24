(ns offcourse.adapters.embedly.queryable
  (:require [ajax.core :refer [GET POST]]
            [cljs.core.async :refer [chan]]
            [clojure.walk :as walk]
            [clojure.string :as str])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn add-defaults [{:keys [url content description title]}]
  {:url url
   :tags #{}
   :tasks #{}
   :title (or title "Couldn't Extract Title")
   :content (or content "Couldn't Extract Content")
   :description (or description "No Description")})

(defn handle-response [response]
  (let [{:keys [type error] :as response} (-> response
                                              walk/keywordize-keys)]
    (if ((keyword type) response)
      ((keyword type) response)
      {:error :not-found})))

(defn parse-response [res]
  (let [resources-data (map (fn [resource-data] (as-> resource-data rd
                                                  (walk/keywordize-keys rd)
                                                  (add-defaults rd)))
                            res)]
    resources-data))


(defn get-resources [endpoint urls]
  (let [c (chan)]
    (GET (str endpoint urls "&maxwidth=500")
        {:handler #(go (>! c %))})
    c))

(defn fetch [{:keys [endpoint]} {:keys [resources]}]
  (let [urls (str/join "," (map :url resources))]
    (go
      (when-not (empty? resources)
        {:type :resources
         :resources (->> (parse-response (<! (get-resources endpoint urls))))}))))
