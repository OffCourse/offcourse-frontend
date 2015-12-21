(ns offcourse.core
  (:require [cljs.core.async :refer [<!]]
            [OffcourseDesignDocs]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.views.debug :as debug])
  (:require-macros [cljs.core.async.macros :refer [go]]))


(defn render [db]
  (let [design-doc (.-course js/OffcourseDesignDocs)]
    (go
      (let [response (<! (pouchdb/bootstrap-db db design-doc))]
        (debug/render response)))))
