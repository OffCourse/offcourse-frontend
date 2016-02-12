(ns offcourse.styles.typography
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [units :as u :refer [px]]
             [stylesheet :refer [at-font-face]]]))

(defn make-at-font-face [[font-name file-name]]
  (at-font-face {:font-family font-name
                 :font-weight 300
                 :src         (str "url('/fonts/" file-name ".woff') " "format('woff')")}))

(defn title [{:keys [fonts]}]
  [:.title {:font-family (:title fonts)}])

(defn label [{:keys [templates colors units]}]
  [:.label {:display          :inline-flex
            :height           (:full units)
            :margin-right     (:sixth units)
            :margin-bottom    (:sixth units)
            :font-size        (* (:atom units) 13)
            :align-items      :center
            :justify-content  :center
            :padding          [[0 (:third units)]]
            :border           (:border templates)
            :background-color (:day colors)}])


(defn textbar [{:keys [colors units] :as config}]
  [:.textbar {:outline         :none
              :display          :inline-block
              :font-size        (:subtitle-font units)
              :line-height      (:subtitle-line-height units)
              :padding          [[0 (:third units)]]
              :border           :none
              :background-color (:night colors)
              :color            (:day colors)}])

(defn typography [{:keys [fonts] :as config}]
  (let [components [title label textbar]]
    [(map make-at-font-face (:raw fonts))
     (for [component components]
       (component config))]))

