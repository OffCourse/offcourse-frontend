(ns offcourse.core
  (:require [offcourse.system.components.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defn app [bootstrap-docs]
  (system bootstrap-docs {:courses (pouchdb/new-db :courses-db bootstrap-docs)
                          :resources (fakedb/new-db :resources-db)}))
