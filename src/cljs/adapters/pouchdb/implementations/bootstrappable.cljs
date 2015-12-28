(ns adapters.pouchdb.implementations.bootstrappable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [adapters.pouchdb.wrapper :as wrapper]
            [offcourse.helpers.interop :refer [jsx->clj handle-js-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn- bootstrap-data [{:keys [bootstrap-docs] :as db}]
  (go
    (<! (qa/refresh db {:docs bootstrap-docs}))
    (if-let [valid? (<! (va/valid? db))]
      {:status :db-bootstrapped}
      {:status :error
       :error :missing-data})))

(defn bootstrap [{:keys [bootstrap-docs] :as db}]
  (go
    (if-let [valid? (<! (va/valid? db))]
      {:status :db-ready}
      (<! (bootstrap-data db)))))
