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
        user-name (-> proposal :user :user-name)
        auth-token (-> proposal :auth-token)]
    #_(println old-type new-type)
    (cond
      (and (= old-type :signup) (= new-type :signup)) true
      (and (= old-type :new-course) (= new-type :new-course)) true
      (and (= new-type :new-course) (not user-name)) false
      (and (= old-type :signup) (and auth-token (not user-name))) false
      :default true)))
