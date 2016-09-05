(ns offcourse.appstate.check
  (:require [shared.protocols.validatable :as va]))

(defn viewmodel-type [{:keys [viewmodel] :as state}]
  (when viewmodel (va/resolve-type viewmodel)))

(defn check [{:keys [state]} proposal]
  (let [old-type (viewmodel-type @state)
        new-type(viewmodel-type proposal)
        user-name (some-> proposal :user :user-name)
        auth-token (some-> proposal :auth-token)]
    (cond
      (and (= old-type :signup) (= new-type :signup)) true
      (and (= old-type :new-course) (= new-type :new-course)) true
      (and (= new-type :new-course) (not user-name)) false
      (and (= old-type :signup) (and auth-token (not user-name))) false
      :default true)))
