(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.helpers.string :as sh]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn missing [requested result field query]
  (let [field-singular (sh/singular field)
        requested (into #{} (field query))
        found (into #{} (map (comp str field-singular) result))
        missing (set/difference requested found)]
    (if (empty? missing) false (into [] missing))))

(defn fetch-1 [{:keys [service] :as api} {:keys [type] :as query} converter]
  (go
    (let [result (<! (qa/fetch service query))]
      (if (:error result)
        (ri/respond api :failed-fetch query)
        (ri/respond api :fetched-data type (converter result))))))

(defn fetch-m [{:keys [service] :as api} {:keys [type] :as query} converter field]
  (go
    (let [result (remove nil? (<! (qa/fetch service query)))]
      (if (or (:error result) (empty? result))
        (ri/respond api :failed-fetch query)
        (let [converted (map converter result)
              missing? (missing query converted field query)]
          (if missing?
            (ri/respond api :failed-fetch (assoc query field missing?))
            (ri/respond api :fetched-data type converted)))))))

(defn fetch [{:keys [fetchables] :as api} {:keys [type] :as query}]
  (if-let [[converter field] (type fetchables)]
    (if field
      (fetch-m api query converter field)
      (fetch-1 api query converter))
    (ri/respond api :query-not-supported query)))
