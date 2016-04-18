(ns offcourse.appstate.check
  (:require [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]
            [offcourse.views.helpers :as vh]
            [offcourse.protocols.validatable :as va]))

(defn viewmodel-type [state]
  (-> state :viewmodel :type))

(defmulti check
  (fn [_ {:keys [type]}]type))

(defmethod check :permissions [{:keys [state] :as as} {:keys [proposal]}]
  (let [old-type (viewmodel-type @state)
        new-type(viewmodel-type proposal)
        user-name (-> proposal :user :name)]
    (cond
      (and (= old-type :new-user-view) (= new-type :new-user-view)) true
      (and (= old-type :new-user-view) (not user-name)) false
      :default true)))

(defmethod check :default [{:keys [queries state] :as as} query]
  (if (set/subset? queries #{(hash query)})
    (qa/refresh as (vh/home-view))
    (respond as :not-found-data query)))
