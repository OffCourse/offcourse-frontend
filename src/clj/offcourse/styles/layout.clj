(ns offcourse.styles.layout
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [vh vw px percent]]]
            [offcourse.styles.classes :as c]))

(defn layout [{:keys [units colors]}]
  [[c/container {:display :flex
                 :flex-direction :row
                 :flex 1
                 :padding [[0 0 (:full units) 0]]}]
   [:.layout--app        {:display          :flex
                          :height           (vh 100)
                          :width            (vw 100)
                          :align-content    :stretch
                          :flex-direction   :column
                          :overflow         :hidden
                          :background-color (:light colors)}]
   [:.layout--menubar    {:display          :flex
                          :width            (percent 100)
                          :background-color (:primary colors)
                          :flex             [[0 0 (:three units)]]}]
   [:.layout--dashboard  {:height        (percent 100)
                          :align-content :stretch}]
   [:.layout--main       {:flex-direction :row
                          :display        :flex}]
   [:.layout--content       {:display        :flex
                             :flex-grow      2
                             :overflow       :scroll
                             :flex-direction :row}]])
