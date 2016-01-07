(ns offcourse.api.implementations.bootstrappable
  (:require [cljs.core.async :refer [<! >! timeout]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.bootstrappable :refer [bootstrap]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn -bootstrap [{:keys [courses-service resources-service] :as api}]
  (go
    (let [cs-response  (<! (bootstrap courses-service))
          cs-ready?    (= (:type cs-response) :db-ready)
          rs-response  (<! (bootstrap resources-service))
          rs-ready?    (= (:type rs-response) :db-ready)]
      (if (and cs-ready? rs-ready?)
        (ri/listen api)
        (ri/respond api :api-error [rs-response cs-response])))))
