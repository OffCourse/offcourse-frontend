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

(defn query [type name id]
  {:collection-type type
   :collection-name name
   :course-ids #{id}})

(defmethod refresh :collections [store {:keys [course]}]
  (let [course-id (:course-id course)
        curator-query [(query :curators (:curator course) course-id)]
        flag-queries (map #(query :flags % course-id) (:flags course))
        tag-queries (map #(query :tags % course-id) (qa/get course :tags {}))
        queries [curator-query flag-queries tag-queries]]
    (reduce #(qa/refresh %1 :collection %2) store (flatten queries))))

(defmethod refresh :collection [store {:keys [collection] :as query}]
  (if (qa/get store query)
    (transform (paths/collection collection)
               #(qa/refresh % query)
               store)
    (qa/add store query)))

(defmethod refresh :course [store query]
  (if-let [missing-query (va/missing-data store query)]
    (qa/add store query)
    store))

(defmethod refresh :data [store query]
  (if-let [missing-query (va/missing-data store query)]
    (qa/add store missing-query)
    store))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
