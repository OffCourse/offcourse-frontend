(ns offcourse.models.course.get
  (:refer-clojure :exclude [get])
  (:require [clojure.set :as set]
            [cuerdas.core :as str]
            [com.rpl.specter :refer [ALL select-first]]))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :tags [course _]
  (->> course
       :checkpoints
       (map :tags)
       (apply set/union)
       (into #{})))

(defmethod get :url [{:keys [checkpoints]} {:keys [checkpoint-slug]}]
  (when checkpoints
    (select-first [ALL #(= (:checkpoint-slug %) checkpoint-slug) :url] checkpoints)))

(defmethod get :checkpoint [course {:keys [checkpoint]}]
  (if-let [checkpoint-slug (or (:checkpoint-slug checkpoint) (str/slugify (:task checkpoint)))]
    (do
      (->> (:checkpoints course)
           (some #(if (= (:checkpoint-slug %) checkpoint-slug) %))))
    (->> (:checkpoints course)
         (some #(if (= (:checkpoint-id %) (:checkpoint-id checkpoint)) %)))))

(defmethod get :urls [course _]
  (->> course
       :checkpoints
       (map :url)
       (into #{})))

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
