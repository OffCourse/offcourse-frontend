(ns offcourse.api.lifecycle
  (:require [cljs.core.async :refer [<! >! close!]]
            [offcourse.protocols.bootstrappable :as ba]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn start [{:keys [courses-service resources-service] :as api}]
  (go
    (let [cs-response  (<! (ba/bootstrap courses-service))
          cs-ready?    (= (:type cs-response) :db-ready)
          rs-response  (<! (ba/bootstrap resources-service))
          rs-ready?    (= (:type rs-response) :db-ready)]
      (if (and cs-ready? rs-ready?)
        (assoc api :listener (ri/listen api))
        (ri/respond api :api-error [rs-response cs-response])))))

(defn stop [{:keys [input-channel] :as api}]
  (do
    (close! input-channel)
    (dissoc api :listener)))
