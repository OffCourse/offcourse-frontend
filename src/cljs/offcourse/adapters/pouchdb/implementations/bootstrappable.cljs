(ns offcourse.adapters.pouchdb.implementations.bootstrappable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.responsive :as ri]
            [wrappers.pouchdb :as wrapper]
            [offcourse.helpers.interop :refer [jsx->clj handle-js-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn- bootstrap-data [{:keys [bootstrap-docs] :as db}]
  (go
    (<! (qa/refresh db {:type :docs
                        :docs bootstrap-docs}))
    (if-let [valid? (<! (va/valid? db))]
      (ri/respond db :db-bootstrapped)
      (ri/respond db :db-not-bootstrapped))))

(defn bootstrap [{:keys [bootstrap-docs] :as db}]
  (go
    (if-let [valid? (<! (va/valid? db))]
      (ri/respond db :db-ready)
      (<! (bootstrap-data db)))))
