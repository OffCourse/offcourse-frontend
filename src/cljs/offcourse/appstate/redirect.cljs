(ns offcourse.appstate.redirect
  (:require [offcourse.models.action :as action]
            [offcourse.models.payload.index :as payload]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.profile.index :as pf]))

(defmulti redirect (fn [as destination & _] destination))

(defmethod redirect :home [{:keys [component-name] :as as} destination]
  (qa/refresh as (action/new as :requested-view (payload/new :home-view))))

(defmethod redirect :signup [{:keys [component-name] :as as} destination]
  (qa/refresh as (action/new as :requested-view (payload/new :signup-view (pf/new {})))))

(defmethod redirect :course [{:keys [component-name] :as as} destination course]
  (qa/refresh as (action/new as :requested-view (payload/new :course-view course))))
