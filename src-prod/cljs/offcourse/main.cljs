(ns offcourse.main
  (:require [offcourse.core :refer [render]]))

(set! cljs.core/*print-fn* identity)

(defn init []
  (render)
  (println "now you don't"))
