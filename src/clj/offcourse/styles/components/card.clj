(ns offcourse.styles.components.card
  (:require [offcourse.styles.helpers :as h]))

(defn container [{:keys [one-and-half column]} {:keys [light]}]
  [:.container--card {:display          :inline-block
                      :width            column
                      :padding          0}])

(defn component [{:keys [component highlighted]} {:keys [full atom third sixth]} {:keys [day medium primary night]}]
  [:.card (h/augment component {:padding-bottom   full
                                :border-bottom       [[:solid sixth medium]]
                                :background-color day})
   [:&:hover {:border-color [primary]}]])

(defn card-section [{:keys [full half two-third]}] {:padding [[0 full two-third full]]})

(defn card-sections [{:keys [map two-third half full]} {:keys [night]}]
  [[:.card--map         {:height           map
                         :background-color night}]
   [:.card--title       {:padding-top    two-third
                         :padding-bottom two-third}]
   [:.card--meta        {:padding [[half full]]}]
   [:.card--description {}]
   [:.card--tags        {:padding-bottom 0}]
   [:.card--checkpoints {:padding-bottom full}]])

(defn overrides [units colors]
  [[:.card--title :.title {:font-size   (:title-font units)
                           :line-height (:title-line-height units)}]
  [:card--meta :.keyword {:margin-right (:tenth units)}]])

(defn card [{:keys [templates units colors]}]
  (let [base-component (:component templates)]
    [(container units colors)
     (component templates units colors)
     (h/augment-many (card-section units) (card-sections units colors))
     (overrides units colors)]))
