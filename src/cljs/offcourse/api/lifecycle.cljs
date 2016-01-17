(ns offcourse.api.lifecycle
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.protocols.bootstrappable :as ba]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn start [{:keys [courses user-courses resources] :as api}]
  (go
    (let [cs-response  (<! (ba/bootstrap courses))
          cs-ready?    (= (:type cs-response) :db-ready)
          us-response  (<! (ba/bootstrap user-courses))
          us-ready?    (= (:type us-response) :db-ready)
          rs-response  (<! (ba/bootstrap resources))
          rs-ready?    (= (:type rs-response) :db-ready)]
      (if (and cs-ready? rs-ready? us-ready?)
        (assoc api :listener (ri/listen api))
        (ri/respond api :api-error [rs-response cs-response])))))

(defn stop [{:keys [input-channel] :as api}]
  (do
    (close! input-channel)
    (dissoc api :listener)))
