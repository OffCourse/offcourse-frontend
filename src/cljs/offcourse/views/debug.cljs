(ns offcourse.views.debug
  (:require [rum.core :as rum]))

(rum/defc row [[key value]]
  [:tr [:td (name key)] [:td (str value)]])

(defn rows [object]
  (map (fn [pair]
         (-> (row pair)
             (rum/with-key pair)))
       object))

(rum/defc debugger [object]
  [:table
   [:thead
    [:tr [:th "KEY"] [:th "BODY"]]]
   [:tbody (rows object)]])
