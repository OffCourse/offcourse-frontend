(ns offcourse.adapters.pouchdb.implementations.queryable.check
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti check
  (fn [_ {:keys [type]}] type))

(defmethod check :doc [db query]
  (go
    (let [error (:error (<! (qa/fetch db query)))]
      (if error false true))))

(defmethod check :docs [db query]
  (go
    (let [docs         (<! (qa/fetch db query))
          are-missing? (filter :error docs)
          are-deleted? (filter (comp :deleted :value) docs)
          missing-docs (map :id (concat are-missing? are-deleted?))]
      (or (empty? missing-docs) missing-docs))))
