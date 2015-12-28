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

(defn all-docs
  ([pouch include-docs]
   (let [options {"include_docs" include-docs}]
     (handle-js-response (.allDocs pouch (clj->js options)) :rows)))
  ([pouch keys include-docs]
   (let [options {:keys keys
                  "include_docs" include-docs}]
     (handle-js-response (.allDocs pouch (clj->js options)) :rows))))

(defn put-doc [pouch doc]
  (handle-js-response (.put pouch doc)))

(defn bulk-docs [pouch docs]
  (handle-js-response (.bulkDocs pouch (clj->js docs))))
