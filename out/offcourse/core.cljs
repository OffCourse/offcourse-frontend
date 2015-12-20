(ns offcourse.core
  (:require [sablono.core :as html :refer-macros [html]]))

(defonce counter (atom 0))

(defn hello [counter]
  [:p counter])

(defn render []
  (do
    (swap! counter inc)
    (.render js/ReactDOM (html (hello @counter))
             (. js/document (getElementById "container")))))
