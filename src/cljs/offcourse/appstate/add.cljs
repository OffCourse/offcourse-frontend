(ns offcourse.appstate.add
  (:require [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.resource.index :as rs]
            [cuerdas.core :as str]))

(defmulti add (fn [_ {:keys [type] :as query}]
                type))

(defmethod add :query [{:keys [state] :as as}
                       {:keys [missing-data] :as query}]
  (swap! state (fn [state] (update state :queries #(conj % (hash missing-data))))))

(defmethod add :checkpoint [{:keys [state] :as as} query]
  (let [checkpoint (get-in @state [:viewmodel :dependencies :checkpoint])]
    (when (va/valid? checkpoint)
      (do
        (qa/refresh as {:type :add-checkpoint
                        :checkpoint checkpoint})
        (qa/refresh as {:type :resource
                        :resource (rs/new checkpoint)})
        (qa/refresh as {:type :reset-checkpoint})))))


(defmethod add :tag [{:keys [state] :as as} query]
  (let [tag (get-in @state [:viewmodel :dependencies :tag])]
    (when (> (count tag) 2)
      (do
        (qa/refresh as {:type :add-tag
                        :tag (-> tag str/slugify keyword)})
        (qa/refresh as {:type :reset-tag})))))

(defmethod add :course [{:keys [state] :as as} query]
  (let [course (-> (:viewmodel @state)
                   (qa/get query)
                   co/complete)]
    (if (va/valid? course)
      (qa/refresh as :course course)
      (.alert js/window "not saved..."))))

(defmethod add :profile [{:keys [state] :as as} query]
  (let [profile (-> (:viewmodel @state)
                    (qa/get query))]
    (if (va/valid? profile)
      (qa/refresh as :profile profile)
      (.alert js/window "not saved..."))))
