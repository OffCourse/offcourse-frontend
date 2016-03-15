(ns offcourse.models.appstate.refresh
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select-first transform]]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(def data-hierarchy
  (-> (make-hierarchy)
      (derive :courses :data)
      (derive :course :data)
      (derive :resources :data)
      (derive :resource :data)))

(defn deep-merge
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (last vs)))

(defmulti refresh (fn [_ {:keys [type]}] type)
  :hierarchy #'data-hierarchy)

(defmethod refresh :view [state {:keys [view-data]}]
  (update state :viewmodel #(qa/refresh % view-data)))

(defmethod refresh :user [state {:keys [user]}]
  (assoc state :user user))

(defmethod refresh :collection [store {:keys [collection] :as query}]
  (when-let [{:keys [collection-type collection-name course-ids]} collection]
    (let [collection-path (paths/collection collection-type collection-name)
          courses-path    [collection-path :course-ids]]
      (if-let [store-ids (select-first courses-path store)]
        (transform courses-path #(set/union store-ids course-ids) store)
        (transform [:collections] #(conj % collection) store)))))

(defmethod refresh :data [store query]
  (if-let [missing-courses (va/missing-data store query)]
    (qa/add store missing-courses)
    store))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
