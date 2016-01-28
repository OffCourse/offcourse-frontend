(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defn app [bootstrap-docs]
  (system bootstrap-docs {:user-courses (pouchdb/new-db :courses-db bootstrap-docs)
                          :courses  (fakedb/new-db :courses-db)
                          :resources (fakedb/new-db :resources-db)}))
