(ns offcourse.styles.typography
  (:refer-clojure :exclude [+ - * /])
  (:require [garden.stylesheet :refer [at-font-face]]
            [offcourse.styles.vocabulary :as v]))

(defn make-at-font-face [[font-name file-name]]
  (at-font-face {:font-family font-name
                 :font-weight 500
                 :src (str "url('/fonts/" file-name ".woff') " "format('woff')")}))

(defn title [{:keys [templates]}]
  [v/title (:title templates)])

(defn subtitle [{:keys [templates]}]
  [v/subtitle (:subtitle templates)])

(defn logo [{:keys [templates colors units fonts] :as config}]
  [v/logo (:textbar templates)
   [v/hovered (:paper templates)]])

(defn typography [{:keys [fonts] :as config}]
  (let [components [title subtitle logo]]
    [(map make-at-font-face (:raw fonts))
     (for [component components]
       (component config))]))
