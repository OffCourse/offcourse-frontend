(ns offcourse.models.response.converters
  (:require [offcourse.models.checkpoint.index :as cp]
            [offcourse.models.course.index :as co]
            [offcourse.models.resource.index :as rs]))

(defn to-checkpoint [{:keys [tags] :as raw}]
  (-> raw
      (assoc :tags (into #{} (map keyword tags)))
      cp/map->Checkpoint))

(defn to-course [{:keys [curator version flags forks checkpoints] :as raw}]
  (-> raw
      (assoc :curator (keyword curator)
             :flags (into #{} (map keyword flags))
             :version (if nil? [] version)
             :forks (into #{} forks)
             :checkpoints (map to-checkpoint checkpoints))
      co/map->Course))

(defn to-resource [obj]
  (let [resource (rs/map->Resource obj)]
    resource))
