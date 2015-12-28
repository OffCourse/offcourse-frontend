(ns adapters.pouchdb.implementations.validatable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.helpers.interop :refer [jsx->clj handle-js-response]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn get-db-doc-id [doc]
  (:_id (jsx->clj doc)))

(defn valid? [{:keys [bootstrap-docs] :as db}]
  (go
    (let [doc-ids (map get-db-doc-id bootstrap-docs)
          has-docs? (<! (qa/check db {:keys doc-ids}))]
      (if has-docs? true false))))
