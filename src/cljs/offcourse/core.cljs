(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defn app [bootstrap-docs]
  (system bootstrap-docs [{:adapter         fakedb/new-db
                           :supported-types [:collection-names :collection
                                             :course :courses]
                           :name            :courses-repo}
                          {:adapter         fakedb/new-db
                           :supported-types [:collection-names :collection
                                             :course :courses]
                           :name            :courses-repo2}]))
