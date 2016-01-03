(ns adapters.pouchdb.wrapper
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [cljsjs.pouchdb]
            [cljs.core.match :refer-macros [match]]
            [clojure.set :as set]
            [offcourse.helpers.interop :refer [jsx->clj handle-js-response]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn init [name]
  (js/PouchDB. name))

(defn info [pouch]
  (handle-js-response (.info pouch)))

(defn get-doc [pouch key]
  (handle-js-response (.get pouch key)))

(defn query
  ([pouch viewname options] (query pouch viewname options identity))
  ([pouch viewname options cb]
  (handle-js-response (.query pouch viewname (clj->js options)) (comp cb :rows))))

(defn all-docs
  ([pouch {:keys [include-docs] :as options} cb]
    (let [options (if include-docs
                    (assoc options "include_docs" include-docs)
                    options)
          cb (comp cb :rows)]
   (handle-js-response (.allDocs pouch (clj->js options)) cb)))
  ([pouch options]
     (all-docs pouch options identity)))

(defn put-doc [pouch doc]
  (println doc)
  (handle-js-response (.put pouch doc)))

(defn bulk-docs [pouch docs]
  (handle-js-response (.bulkDocs pouch (clj->js docs))))
