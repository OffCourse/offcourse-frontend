(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]))

(defn app [adapters auth-config cloud-config]
  (system "Offcourse_"
          adapters
          auth-config
          cloud-config))
