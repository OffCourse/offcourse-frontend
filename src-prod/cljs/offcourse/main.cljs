(ns offcourse.main
  (:require [offcourse.core :refer [render]]))

(defn init []
  (render)
  (.log js/console "initialized from prod"))
