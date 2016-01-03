(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<! >! put! timeout]]
            [offcourse.models.course :as co]
            [offcourse.helpers.converters :as cv]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn convert [query result]
  (match [query]
         [{:type :collection-names}]  result
         [{:collection _}]        (ci/to-collection result)
         [{:courses _}]           (map ci/to-course result)
         [{:course _}]            (ci/to-course result)))

(defn fetch [{:keys [service] :as api} query]
  (go
    (let [response (<! (qa/fetch service query))
          result {:type (:type query)
                  (:type query) (convert query response)}]
      (ri/respond api :fetched-data result))))

