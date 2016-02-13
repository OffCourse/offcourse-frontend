(ns offcourse.styles.components.card
  (:require [offcourse.styles.helpers :as h]))

(defn container [{:keys [one-and-half column]} {:keys [light]}]
  [:.container--card {:display          :inline-block
                      :width            column
                      :padding          [[0 0 one-and-half 0]]}])

(defn component [{:keys [component]} {:keys [full]} {:keys [day]}]
  [:.card (h/augment component {:padding-bottom   full
                                :background-color day})])

(defn card-section [{:keys [full half]}] {:padding [[0 full half full]]})

(defn card-sections [{:keys [map half full]} {:keys [night]}]
  [[:.card--map         {:height           map
                         :background-color night}]
   [:.card--title       {:padding-top    full
                         :padding-bottom 0}]
   [:.card--meta        {:padding [[half full]]}]
   [:.card--description {}]
   [:.card--tags        {:padding-top half}]
   [:.card--checkpoints {:padding-top half}]])

(defn overrides [units colors]
  [[:.card--title :.title {:font-size   (:title-font units)
                            :font-weight 500
                            :line-height (:title-line-height units)}]
  [:card--meta :.keyword {:margin-right (:tenth units)}]])

(defn card [{:keys [templates units colors]}]
  (let [base-component (:component templates)]
    [(container units colors)
     (component templates units colors)
     (h/augment-many (card-section units) (card-sections units colors))
     (overrides units colors)]))
