(ns offcourse.views.app
  (:require [rum.core :as rum]
            [offcourse.models.course :as co]
            [clojure.string :as str]
            [faker.lorem :as lorem]
            [cljs.pprint :as pp]))

(defn rand-int-between [min max]
  (let [dev (- max min)]
    (+ (rand-int dev) min)))

(rum/defc logo []
  [:button.logo.textbar.title "Offcourse_"])

(rum/defc label [{:keys [label-name] :as label}]
  (let [label-name (or label-name label)
        title (name label-name)]
    [:span.label (str title " ")]))

(rum/defc collection-panel [[category-name collection]]
  (let [title (name category-name)]
    [:.collection-panel
     [:.collection-panel.collection-panel__title {:key :title}
      [:h1.title (name category-name)]]
     [:.collection-panel.collection-panel__labels.labels {:key :labels}
      (map #(rum/with-key (label %) (:label-name %)) collection)]]))

(rum/defc dashboard [label-collections]
  [:.dashboard
   [:.dashboard.dashboard__logo (logo)]
   [:.dashboard.dashboard__collections
    (map #(rum/with-key (collection-panel %) %) label-collections)]])

(rum/defc todo-list-item [{:keys [task]}]
  [:li.todo-list--item
   [:p
    [:span.checkbox {:key :checkbox} nil]
    [:span {:key :title} task]]])

(rum/defc todo-list [checkpoints]
  [:ul.todo-list
   (map #(rum/with-key (todo-list-item %) (:order %)) checkpoints)])

(rum/defc labels [labels]
   [:.labels (map #(rum/with-key (label %) %) labels)])

(rum/defc card [{:keys [goal checkpoints curator] :as course}]
  [:.container--card
   [:.card
    [:.card--map]
    [:.card--title
     [:h1.title goal]]
    [:.card--meta
     [:p {:key :curator}  [:span.keyword "Curator: "] (name curator)]
     [:p {:key :learners} [:span.keyword "Learners: "] (rand-int-between 1 40)]]
    [:.card--description
     [:p (->> (lorem/words)
              (take (rand-int-between 10 40))
              (map #(str/capitalize %1))
              (str/join " "))]]
    [:.card--tags (labels (co/get-tags course))]
    [:.card--checkpoints (todo-list checkpoints)]]])

(rum/defc cards [items]
  [:.cards
   (map #(rum/with-key (card %) (:course-id %)) items)])

(rum/defc app [{:keys [labels courses]}]
  [:.app.layout--app
   [:.layout--dashboard (dashboard labels)]
   [:.layout--main (cards courses)]])
