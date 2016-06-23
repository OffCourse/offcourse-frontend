(ns offcourse.core
<<<<<<< HEAD
  (:require [offcourse.system.index :refer [system]]))
=======
  (:require [offcourse.system.index :refer [system]]
            [offcourse.adapters.pouchdb.index :as pouchdb]
            [offcourse.adapters.fakedb.index :as fakedb]))
>>>>>>> 48199ef... clean up main files

(defn app [adapters auth-config cloud-config]
  (system "Offcourse_"
          adapters
          auth-config
          cloud-config))
