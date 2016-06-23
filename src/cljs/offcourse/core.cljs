(ns offcourse.core
  (:require [offcourse.system.index :refer [system]]))

(defn app [appstate adapters auth-config]
  (system appstate
          adapters
          auth-config))
