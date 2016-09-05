(ns offcourse.appstate.redirect
  (:require [shared.protocols.responsive :as qa]
            [shared.models.event.index :as event]
            [shared.models.viewmodel.index :as viewmodel]))

(defmulti redirect (fn [as destination & _] destination))

(defmethod redirect :home [{:keys [component-name] :as as} destination]
  (->> [component-name :requested-view (viewmodel/create :home-view)]
       event/create
       (qa/react as)))

(defmethod redirect :signup [{:keys [component-name] :as as} destination]
  (->> [component-name :requested-view (viewmodel/create :signup-view)]
       event/create
       (qa/react as)))

(defmethod redirect :course [{:keys [component-name] :as as} destination course]
  (->> [component-name :requested-view (viewmodel/create :course-view course)]
       event/create
       (qa/react as)))
