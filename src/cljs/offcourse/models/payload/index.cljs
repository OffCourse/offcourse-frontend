(ns offcourse.models.payload.index
  (:require [offcourse.protocols.convertible :refer [Convertible]]
            [offcourse.models.payload.to-url :refer [to-url]]
            [schema.core :as schema]))

(defrecord Payload [type]
  Convertible
  (to-url [this routes] (to-url this routes))
  (to-courses [this] (println this)))

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

(defmethod new :signup-view [type user]
  (map->Payload {:type :signup
                 :new-user user}))

(defmethod new :new-course-view [type {:keys [new-course new-checkpoint]}]
  (map->Payload {:type :new-course
                 :new-course     new-course
                 :new-checkpoint new-checkpoint}))

(defmethod new :default [type result]
  (map->Payload {:type type
                 type result}))

