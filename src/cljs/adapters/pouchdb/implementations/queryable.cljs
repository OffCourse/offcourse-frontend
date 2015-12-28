(ns adapters.pouchdb.implementations.queryable
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [adapters.pouchdb.wrapper :as wrapper]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.queryable :as qa])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn- check-doc [pouch query]
  (go
    (let [error (:error (<! (qa/fetch pouch query)))]
      (if error false true))))

(defn- check-docs [pouch query]
  (go
    (let [docs (<! (qa/fetch pouch query))
          are-missing? (filter :error docs)
          are-deleted? (filter (comp :deleted :value) docs)]
      (and (empty? are-missing?) (empty? are-deleted?)))))

(defn fetch [{:keys [connection]} query]
  (match [query]
         [{:course course}](wrapper/get-doc connection (:id course))
         [{:key key}](wrapper/get-doc connection key)
         [{:keys keys :include-docs incd}] (wrapper/all-docs connection keys incd)
         [{:keys keys}] (wrapper/all-docs connection keys true)))

(defn refresh [{:keys [connection]} query]
  (match [query]
         [{:doc doc}] (wrapper/put-doc connection doc)
         [{:docs docs}] (wrapper/bulk-docs connection docs)))

(defn check [pouch query]
  (match [query]
         [{:key key}](check-doc pouch query)
         [{:keys keys}](check-docs pouch query)))
