(ns offcourse.appstate.appstore)

(defrecord Appstore [view])

(defn new [view]
  (map->Appstore {:view view}))
