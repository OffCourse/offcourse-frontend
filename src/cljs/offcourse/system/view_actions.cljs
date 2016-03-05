(ns offcourse.system.view-actions
  (:require [plumbing.core :refer-macros [fnk]]))

(def view-actions
  {:sign-in        (fn [] (println "HI"))})
