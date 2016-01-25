(ns offcourse.views.debug
  (:require [cljsjs.fixed-data-table]
            [offcourse.models.course :as co]
            [rum.core :as rum]))

(def Table (js/React.createFactory js/FixedDataTable.Table))
(def Column (js/React.createFactory js/FixedDataTable.Column))
(def Cell (js/React.createFactory js/FixedDataTable.Cell))

(defn getter [k row]
  (println (keys row))
  (get row (keyword k)))

(rum/defc debugger [{:keys [courses]}]
  (println courses)
  (let [get-tasks   (partial mapv :task)
        courses (mapv (fn [course] (assoc course :tags (co/get-tags course)
                                          :tasks (get-tasks (:checkpoints course)))) courses)
        row-height 120
        cell-width 60
        width      2000
        rows-count (count courses)]
    [:div {} (Table #js {:width        width
                         :height       1000
                         :rowHeight    row-height
                         :rowGetter    #(get courses %)
                         :rowsCount    rows-count
                         :headerHeight (/ row-height 2)}
                    (Column #js {:label "course-id"
                                 :dataKey "course-id"
                                 :width (* 7 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "goal"
                                 :dataKey "goal"
                                 :width (* 4 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "curator"
                                 :dataKey "curator"
                                 :width (* 2 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "flags"
                                 :dataKey "flags"
                                 :width (* 4 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "tags"
                                 :dataKey "tags"
                                 :width (* 6 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "tasks"
                                 :dataKey "tasks"
                                 :width (* 6 cell-width)
                                 :cellDataGetter getter})
                    )]))


