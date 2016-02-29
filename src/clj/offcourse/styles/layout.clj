(ns offcourse.styles.layout
  (:refer-clojure :exclude [+ - * /])
  (:require [garden
             [arithmetic :refer [*]]
             [units :as u :refer [vh vw px percent]]]))

(defn layout [{:keys [units colors]}]
  [[:.layout--app        {:display          :flex
                          :height           (vh 100)
                          :width            (vw 100)
                          :align-content    :stretch
                          :flex-direction   :column
                          :background-color (:light colors)}]
   [:.layout--menubar    {:display          :flex
                          :width            (percent 100)
                          :background-color (:primary colors)
                          :flex             [[0 0 (:three units)]]}]
   [:.layout--dashboard  {:height        (percent 100)
                          :align-content :stretch}]
   [:.layout--main       {:flex-direction :row
                          :height         (percent 100)
                          :display        :flex
                          :overflow-y     :scroll}
    [:.layout--content       {:justify-content :flex-start
                              :display            :flex
                              :background-color   (:day colors)
                              :flex-direction     :row
                              :width              (percent 100)}]]])
