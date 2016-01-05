(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn convert [query result]
  (match [query]
         [{:type :collection-names}]  result
         [{:type :collection}]        (ci/to-collection result)
         [{:type :courses}]           (map ci/to-course result)
         [{:type :course}]            (ci/to-course result)))

(defn fetch [{:keys [service] :as api} query]
  (go
    (let [response (<! (qa/fetch service query))
          result (convert query response)
          payload {:type (:type query)
                  (:type query) result}]
      (ri/respond api :fetched-data payload))))
