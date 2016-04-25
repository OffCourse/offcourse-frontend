(ns offcourse.models.appstate.refresh
  (:require [clojure.set :as set]
            [com.rpl.specter :refer [select-first transform]]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.viewmodel.index :as vm]))

(def data-hierarchy
  (-> (make-hierarchy)

      (derive :add-checkpoint    :dependencies)
      (derive :delete-checkpoint :dependencies)
      (derive :update-goal       :dependencies)
      (derive :update-curator    :dependencies)
      (derive :update-task       :dependencies)
      (derive :update-url        :dependencies)
      (derive :update-tag        :dependencies)
      (derive :reset-checkpoint  :dependencies)
      (derive :reset-tag         :dependencies)
      (derive :add-tag           :dependencies)
      (derive :update-user-name  :dependencies)

      (derive :toggle-checkpoint :course)

      (derive :collection-view   :viewmodel)
      (derive :checkpoint-view   :viewmodel)
      (derive :course-view       :viewmodel)
      (derive :new-course-view   :viewmodel)
      (derive :new-user-view     :viewmodel)
      (derive :loading-view      :viewmodel)

      (derive :courses           :data)
      (derive :resources         :data)))

(defmulti refresh (fn [_ {:keys [type]}] type)
  :hierarchy #'data-hierarchy)

(defmethod refresh :dependencies [state query]
  (update-in state [:viewmodel :dependencies] #(qa/refresh % query)))

(defmethod refresh :profile [state {:keys [profile] :as query}]
  (if profile
    (qa/refresh state :user {:name (:user-name profile)})
    (qa/refresh state :new-user-view {})))

(defmethod refresh :viewmodel [{:keys [user] :as state} query]
  (-> state
      (assoc :viewmodel (vm/new query))
      (qa/refresh :update-curator (:name user))))

(defmethod refresh :user [state {:keys [user]}]
  (-> state
      (assoc :user {:name (:user-name user)})
      (qa/refresh :update-curator (:user-name user))))

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
    (transform (paths/collection collection) #(qa/refresh % query) store)
    (qa/add store query)))

(defmethod refresh :course [store {:keys [course checkpoint] :as query}]
  (let [course (or course {:course-id (:course-id checkpoint)})]
    (if (qa/get store :course course)
      (transform (paths/course course) #(qa/refresh % query) store)
      (qa/add store query))))

(defmethod refresh :resource [store query]
  (if-let [missing-query (va/missing-data store query)]
    (qa/add store query)
    store))

(defmethod refresh :data [store query]
  (if-let [missing-query (va/missing-data store query)]
    (qa/add store missing-query)
    store))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
