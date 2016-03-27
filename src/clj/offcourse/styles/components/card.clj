(ns offcourse.styles.components.card
  (:require [offcourse.styles.helpers :as h]
            [offcourse.styles.modifiers :refer [removable selected hovered]]))

(defn component [{:keys [component highlighted]}
                 {:keys [column full atom third sixth]}
                 {:keys [day medium primary night]}
                 borders]
  [[:.container--card {:display :inline-block
                       :width   column}]
   [:.card (h/augment component {:padding-bottom   full
                                 :border-bottom    (:default borders)
                                 :background-color day})
    [hovered (:highlighted borders)]]])

(defn card-section [{:keys [full half two-third]}] {:padding [[0 full two-third full]]})

(defn card-sections [{:keys [map two-third half full]} {:keys [night]}]
  [[:.card--map         {:height           map
                         :background-color night}]
   [:.card--title       {:padding-top    two-third
                         :padding-bottom two-third}]
   [:.card--meta        {:padding [[half full]]}]
   [:.card--description {}]
   [:.card--tags        {:padding-bottom full}]
   [:.card--checkpoints {:padding-bottom full}]
   [:.card--actions     {:padding-bottom 0}]])

(defn overrides [units colors]
  [[:.card--title :.title {:font-size   (:title-font units)
                           :line-height (:title-line-height units)
                           :border      :none}]
  [:card--meta :.keyword {:margin-right (:tenth units)}]])


(defn card [{:keys [templates units colors borders]}]
  (let [base-component (:component templates)]
    [(component templates units colors borders)
     (h/augment-many (card-section units) (card-sections units colors))
     (overrides units colors)]))
