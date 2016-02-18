(ns offcourse.views.components.button
  (:require [rum.core :as rum]
            [clojure.string :as str]))

(defn titleize [word]
  (as-> word %
    (str/split % "-")
    (map str/capitalize %)
    (str/join " " %)))

(rum/defc button [[key action]]
  (let [title (titleize (name key))]
    [:div.container--btn {:onClick action}
     [:button.btn title]]))
