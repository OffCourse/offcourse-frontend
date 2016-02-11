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

(defn title [{:keys [title-font]}]
  [:.title {:font-family title-font}])

(defn label [{:keys [base-border base-color-light]}]
  [:.label {:display          :inline-flex
            :height           (px 30)
            :margin-right     (px 5)
            :margin-bottom    (px 5)
            :font-size        (px 13)
            :align-items      :center
            :justify-content  :center
            :padding          [[0 (px 10)]]
            :border           base-border
            :background-color base-color-light}])

(defn textbar [{:keys [base-color-dark base-unit title-font base-color-light] :as config}]
  [:.textbar {:outline         :none
              :display          :inline-block
              :font-size        (* (/ base-unit 30) 22)
              :line-height      base-unit
              :padding          [[0 (/ base-unit 3)]]
              :border           :none
              :background-color base-color-dark
              :color            base-color-light}])

(defn typography [{:keys [fonts] :as config}]
  (let [components [title label textbar]]
    [(map make-at-font-face fonts)
     (for [component components]
       (component config))]))

