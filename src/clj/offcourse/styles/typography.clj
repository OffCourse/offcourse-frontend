(ns offcourse.styles.typography
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [* /]]
             [stylesheet :refer [at-font-face]]]))

(defn make-at-font-face [[font-name file-name]]
  (at-font-face {:font-family font-name
                 :font-weight 300
                 :src         (str "url('/fonts/" file-name ".woff') " "format('woff')")}))

(defn title [{:keys [title-font]}]
  [:.title {:font-family title-font}])

(defn textbar [{:keys [base-color-bg base-unit title-font base-color-fg] :as config}]
  [:.textbar {:outline         :none
              :display          :inline-block
              :font-size        (* (/ base-unit 30) 22)
              :line-height      base-unit
              :padding          [[0 (/ base-unit 3)]]
              :border           :none
              :background-color base-color-fg
              :color            base-color-bg}])

(defn typography [{:keys [fonts] :as config}]
  [(map make-at-font-face fonts)
   (title config)
   (textbar config)])

