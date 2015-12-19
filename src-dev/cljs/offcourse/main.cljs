(ns offcourse.main
  (:require [offcourse.core :refer [render]]))

(defn init []
  (render)
  (.log js/console "initialized"))

(defn reload []
  (do
    (.log js/console "reloaded")
    (render)))
