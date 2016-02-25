(ns offcourse.models.appstate)

(defrecord Appstate [view])

(defn new [view]
  (map->Appstate {:view view}))
