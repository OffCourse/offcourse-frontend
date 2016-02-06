(ns offcourse.models.datastore.get
  (:refer-clojure :exclude [get])
  (:require [medley.core :as medley]
            [offcourse.protocols.queryable :as qa]
            [com.rpl.specter :refer [select select-first filterer ALL]]))

(defn checkpoint-by-ids [ds course-id checkpoint-id]
  (select-first [:courses ALL #(= (:course-id %) course-id)
                 :checkpoints ALL #(= (:checkpoint-id %) checkpoint-id)] ds))

(defn course-by-id [ds id]
  (select-first [:courses ALL #(= (:course-id %) id)] ds))

(defn course-by-curator-and-hashtag [ds curator hashtag]
  (select-first [:courses ALL #(and (= (:hashtag %) hashtag)
                           (= (:curator %) curator))] ds))

(defmulti get (fn [_ {:keys [type]}] type))

(defmethod get :collection-names [{:keys [collections]} {:keys [collection-type]}]
  (when (and collections (not (empty? collections)))
    (if (or (not collection-type) (= :all collection-type))
      (medley/map-vals #(into #{} (keys %)) collections)
      (into #{} (keys (collection-type collections))))))

(defmethod get :collection [{:keys [collections]} {:keys [collection]}]
  (when collections
    (let [{:keys [collection-type collection-name]} collection]
      (get-in collections [collection-type collection-name]))))

(defmethod get :courses [{:keys [courses] :as ds} {:keys [course-ids]}]
  (when courses
    (when-let [courses (keep #(course-by-id ds %) course-ids)]
      (if (empty? courses) nil courses))))

(defmethod get :course [{:keys [courses] :as ds} {:keys [course]}]
  (when courses
    (let [{:keys [course-id curator hashtag]} course]
      (or (course-by-id ds course-id)
          (course-by-curator-and-hashtag ds curator hashtag)))))

(defmethod get :resources [{:keys [resources]} {:keys [resource-ids]}]
  (when resources
    (when-let [resources (keep #(get-in resources [%]) resource-ids)]
      (if (empty? resources) nil resources))))

(defmethod get :resource [{:keys [resources]} {:keys [resource]}]
  (when resources
    (when-let [{:keys [resource-id]} resource]
      (get-in resources [resource-id]))))

(defmethod get :default [_ _]
  {:type :error
   :error :query-not-supported})
