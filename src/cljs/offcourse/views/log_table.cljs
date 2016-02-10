(ns offcourse.views.log-table
  (:require [cljsjs.fixed-data-table]
            [offcourse.models.course :as co]
            [medley.core :as medley]
            [rum.core :as rum]))

(def Table (js/React.createFactory js/FixedDataTable.Table))
(def Column (js/React.createFactory js/FixedDataTable.Column))
(def Cell (js/React.createFactory js/FixedDataTable.Cell))

(defn getter [k row]
  (get row k))

(defn store-stats [{:keys [collections courses resources]}]
  {:collections (medley/map-vals count collections)
   :courses     (count courses)
   :resources   (count resources)})

(defn vm-stats [{:keys [collection labels course resource checkpoint-id courses resources]}]
  {:collection    (into {} (assoc collection :course-ids (count (:course-ids collection))))
   :labels        (medley/map-vals count labels)
   :checkpoint-id (when checkpoint-id checkpoint-id)
   :course        (when course course)
   :resource      (when resource (keys resource))
   :courses       (when courses (count courses))
   :resources     (when resources (count resources))})

(defn collection-stats [{:keys [collection]}]
  (assoc collection :course-ids (count (:course-ids collection))))

(defn cln-stats [{:keys [collection-names]}]
  (medley/map-vals count collection-names))

(defn shorten-payload [{:keys [store course-ids viewmodel] :as payload}]
  (cond
    (contains? payload :store)            (assoc payload :store (store-stats store))
    (contains? payload :viewmodel)        (assoc payload :viewmodel (vm-stats viewmodel))
    (contains? payload :collection)       (assoc payload :collection (collection-stats payload))
    (contains? payload :collection-names) (assoc payload :collection-names (cln-stats payload))
    (contains? payload :course-ids)       (assoc payload :course-ids (count course-ids))
    :default                              payload))

(rum/defc debugger [log]
  (let [log (mapv #(conj % (shorten-payload (get % 3))) log)
        row-height 80
        cell-width 60
        width      1380
        rows-count (count log)]
    [:div {} (Table #js {:width        width
                         :height       900
                         :rowHeight    row-height
                         :rowGetter    #(get log %)
                         :rowsCount    rows-count
                         :headerHeight row-height}
                    (Column #js {:label "timestamp"
                                 :dataKey 0
                                 :width (* 3 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "type"
                                 :dataKey 1
                                 :width (* 4 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "source"
                                 :dataKey 2
                                 :width (* 3 cell-width)
                                 :cellDataGetter getter})
                    (Column #js {:label "payload"
                                 :dataKey 4
                                 :width (* 13 cell-width)
                                 :cellDataGetter getter}))]))


