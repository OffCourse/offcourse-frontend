(ns offcourse.models.payload
  (:require [offcourse.models.profile.index :as pf]
            [offcourse.models.course.index :as co]
            [offcourse.models.checkpoint.index :as cp]))

(defrecord Payload [type])

(defmulti new (fn [type result] type))

(defmethod new :permissions [type result]
  (map->Payload {:type :permissions
                 :proposal result}))

(defmethod new :checkpoint-view [type result]
   (map->Payload {:type :checkpoint
                  :course     (select-keys result [:curator :course-slug])
                  :checkpoint (select-keys result [:checkpoint-slug :checkpoint-id])}))

(defmethod new :home-view [type]
  (map->Payload {:type :collection
                 :collection {:collection-type :flags
                              :collection-name :featured}}))

(defmethod new :collection-view [type collection]
  (map->Payload {:type :collection
                 :collection collection}))

(defmethod new :course-view [type data]
  (map->Payload {:type :course
                 :course     (select-keys data [:curator :course-slug])}))

(defmethod new :signup-view []
  (map->Payload {:type :signup
                 :new-user (pf/new {})}))

(defmethod new :new-course-view [type {:keys [curator]}]
  (map->Payload {:type :new-course
                 :new-course     (co/new {:curator curator})
                 :new-checkpoint (cp/new {})}))

(defmethod new :default [type result]
  (when (= type :data) (println result))
  (map->Payload {:type type
                 type result}))
