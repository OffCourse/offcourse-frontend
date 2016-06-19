(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch (fn [_ {:keys [type]}] type))


(defmethod fetch :user-profile [{:keys [repositories] :as api} query]
  (println (:auth-token query))
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources :user-profile)
      (ri/respond api :found-data {:type :user-profile
                                   :user-profile {:user-name :yeehaa}})
      (go
        (let [result (<! (qa/fetch repository query))]
          (println result)
          (when-not (:error result)
            (ri/respond api :found-data :user-profile result)))))))

(defmethod fetch :collection [{:keys [repositories] :as api} query]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources :collection)
      (go
        (let [result (remove nil? (<! (qa/fetch repository query)))]
          (if (or (:error result) (empty? result))
            (ri/respond api :not-found-data query)
            (when-let [converted (keep ci/to-course result)]
              (ri/respond api :found-data :courses converted))))))))

(defmethod fetch :course [{:keys [repositories] :as api} {:keys [course] :as query}]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources :course)
      (go
        (let [result (<! (qa/fetch repository query))]
          (when-not (:error result)
            (ri/respond api :found-data :course (ci/to-course result))))))))

(defmethod fetch :resources [{:keys [repositories] :as api} query]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources :resources)
      (go
        (let [result (remove nil? (<! (qa/fetch repository query)))]
          (if (or (:error result) (empty? result))
            (ri/respond api :not-found-data query)
            (when-let [converted (keep ci/to-resource result)]
              (ri/respond api :found-data :resources converted))))))))
