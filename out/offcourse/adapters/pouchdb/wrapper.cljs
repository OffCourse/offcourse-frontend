(ns offcourse.adapters.pouchdb.wrapper
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [cljsjs.pouchdb]
            [cljs.core.match :refer-macros [match]]
            [clojure.set :as set]
            [offcourse.helpers.interop :refer [jsx->clj handle-js-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn get-db-doc-id [doc]
  (:_id (jsx->clj doc)))

(defn init [name]
  (js/PouchDB. name))

(defn info [pouch]
  (handle-js-response (.info pouch)))

(defn fetch-docs [pouch keys include-docs]
  (handle-js-response (.allDocs pouch (clj->js {:keys keys
                                                :include_docs include-docs}))))

(defn fetch [pouch & opts]
  (let [opts (apply hash-map opts)]
    (match [opts]
           [{:key doc-id}] (handle-js-response (.get pouch doc-id))
           [{:keys keys :include-docs incd}] (fetch-docs pouch keys incd)
           [{:keys keys}] (fetch-docs pouch keys true))))

(defn fetch-doc [pouch doc-id]
  (handle-js-response (.get pouch doc-id)))

(defn refresh-doc [pouch doc]
  (handle-js-response (.put pouch doc)))

(defn has-doc? [pouch doc]
  (go
    (let [doc-id (get-db-doc-id doc)
          error (:error (<! (fetch-doc pouch doc-id)))]
      (if error false true))))

(defn missing-docs [pouch docs]
  (go
    (let [expected-doc-ids (into #{} (map get-db-doc-id docs))
          docs (<! (fetch pouch :keys expected-doc-ids :include-docs false))
          actual-doc-ids (->> docs
                              (remove (fn [doc] (get-in doc [:value :deleted])))
                              (map :id))]
      (set/difference expected-doc-ids actual-doc-ids))))
