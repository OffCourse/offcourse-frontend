(ns offcourse.models.appstate.valid
  (:require [schema.core :as schema]
            [offcourse.protocols.queryable :as qa]))

(defmulti valid? (fn [as _] (-> as :viewmodel :type)))

(defmethod valid? :collection [as as-schema]
  (empty? (schema/check as-schema as)))

(defmethod valid? :course [as as-schema]
  (empty? (schema/check as-schema as)))

(defmethod valid? :checkpoint [as as-schema]
  (empty? (schema/check as-schema as)))

(defmethod valid? :new-course [as as-schema]
  true)

(defmethod valid? :default [as as-schema]
  (println (-> as :viewmodel)))
