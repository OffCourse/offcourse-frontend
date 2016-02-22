(ns offcourse.styles.typography
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* + /]]
             [units :as u :refer [px]]
             [selectors :as s]
             [stylesheet :refer [at-font-face]]]))

(defn make-at-font-face [[font-name file-name]]
  (at-font-face {:font-family font-name
                 :font-weight 500
                 :src         (str "url('/fonts/" file-name ".woff') " "format('woff')")}))

(defn title [{:keys [fonts]}]
  [:.title {:font-family (:title fonts)}])

(defn btn [{:keys [templates colors units fonts]}]
  [[:.container--btn        {:height      (* 2.5 (:full units))
                             :padding     (:full units)
                             :width       (+ (:one-and-half units) (:map units))
                             :padding-top 0}]
   [:.btn {:outline          :none
           :display          :inline-block
           :height           (:one-and-half units)
           :padding          [[0 (:third units)]]
           :width            (:map units)
           :border           :none
           :background-color (:night colors)
           :color            (:day colors)}
    [:&:hover (:highlighted templates)]]])

(defn textbar [{:keys [colors units fonts] :as config}]
  [:.textbar {:outline          :none
              :font-family      (:logo fonts)
              :display          :inline-block
              :font-size        (:subtitle-font units)
              :line-height      (:subtitle-line-height units)
              :padding          [[0 (:third units)]]
              :border           :none
              :background-color (:night colors)
              :color            (:day colors)}
   [:&:hover {:background-color (:day colors)
              :color (:night colors)}]])

(defn typography [{:keys [fonts] :as config}]
  (let [components [title btn textbar]]
    [(map make-at-font-face (:raw fonts))
     (for [component components]
       (component config))]))
