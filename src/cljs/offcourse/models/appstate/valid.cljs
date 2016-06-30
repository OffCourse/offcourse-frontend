(ns offcourse.models.appstate.valid
  (:require [offcourse.protocols.queryable :as qa]
            [cljs.spec :as spec]
            [offcourse.specs.appstate :as specs]))

(defmulti valid? (fn [as] (-> as :viewmodel :type)))

(defmethod valid? :collection [as as-schema]
  (spec/valid? ::specs/appstate as))

(defmethod valid? :course [as as-schema]
  (spec/valid? ::specs/appstate as))

(defmethod valid? :checkpoint [as as-schema]
  (spec/valid? ::specs/appstate as))

(defmethod valid? :new-course [as as-schema]
  true)

(defmethod valid? :signup [{:keys [auth-token]} as-schema]
  (if auth-token true false))

(defmethod valid? :default [as as-schema]
  false)
