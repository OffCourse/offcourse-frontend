(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.fakedb.index :as fakedb]))

(defn app [adapters auth-config cloud-config]
  (system "Offcourse_"
          adapters
          auth-config
          cloud-config))
