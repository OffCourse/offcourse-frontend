(ns offcourse.models.response.index
  (:require [offcourse.protocols.convertible :refer [Convertible]]
            [clojure.walk :as walk]
            [offcourse.models.response.to-payload :refer [to-payload]]))

(defrecord Response [type]
  Convertible
  (to-payload [this] (to-payload this)))

(defn new [res]
  (let [response (-> res
                     walk/keywordize-keys
                     (update-in [:type] #(keyword %)))]
    (map->Response response)))
