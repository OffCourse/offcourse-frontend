(ns offcourse.specs.payload
  (:require [cljs.spec :as spec]
            [offcourse.specs.appstate :as appstate]
            [offcourse.specs.base :as base]
            [offcourse.specs.courses :as courses]
            [offcourse.specs.collections :as collections]

            [offcourse.specs.resources :as resources]))

(defmulti payload (fn [{:keys [type]}] (or type :default)))
(defmethod payload :user-profile [_]
  (spec/keys :req-un [::base/type]
             :opt-in [::base/user-profile ::base/auth-token]))
(defmethod payload :appstate [_]
  (spec/keys :req-un [::base/type ::appstate/appstate]))
(defmethod payload :auth-token [_]
  (spec/keys :req-un [::base/type ::base/auth-token]))
(defmethod payload :collection [_]
  (spec/keys :req-un [::base/type ::collections/collection]))
(defmethod payload :course [_]
  (spec/keys :req-un [::base/type ::courses/course]))
(defmethod payload :courses [_]
  (spec/keys :req-un [::base/type ::courses/courses]))
(defmethod payload :resources [_]
  (spec/keys :req-un [::base/type ::resources/resources]))
(defmethod payload :default [_] nil?)

(spec/def ::payload (spec/multi-spec payload :type))
