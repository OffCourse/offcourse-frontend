(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<! >! put! timeout]]
            [offcourse.models.course :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn fetch [{:keys [service] :as api} query]
  (go
    (let [course-map (<! (qa/fetch service query))
          course     (co/from-map course-map)]
      (println (co/from-json (ci/to-json course)))
      (ri/respond api :fetched-data course))))
