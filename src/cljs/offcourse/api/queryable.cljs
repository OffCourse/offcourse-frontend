(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.helpers.string :as sh]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn fetch-1 [api repository {:keys [type] :as query} converter]
  (go
    (let [result (<! (qa/fetch repository query))]
      (if (:error result)
        (ri/respond api :failed-fetch query)
        (ri/respond api :fetched-data type (converter result))))))

(defn fetch-m [api repository {:keys [type] :as query} converter field]
  (go
    (let [result (remove nil? (<! (qa/fetch repository query)))]
      (if (or (:error result) (empty? result))
        (ri/respond api :failed-fetch query)
        (let [converted (map converter result)]
          (ri/respond api :fetched-data type converted))))))

(defn fetch [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (if-let [[converter field] (type fetchables)]
    (doseq [repository repositories]
      (if field
        (fetch-m api repository query converter field)
        (fetch-1 api repository query converter)))
    (ri/respond api :query-not-supported query)))
