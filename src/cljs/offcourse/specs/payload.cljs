(ns offcourse.specs.payload
  (:require [cljs.spec :as spec]
            [offcourse.specs.appstate :as appstate]
            [offcourse.specs.base :as base]
            [offcourse.specs.courses :as courses]
            [offcourse.specs.collections :as collections]
            [offcourse.specs.resources :as resources]))

(spec/def ::auth-token (spec/nilable ::base/auth-token))

(spec/def ::course (spec/or :course ::courses/course
                            :course-data ::courses/course-data))

(defmulti payload :type)

(defmethod payload :user-profile [_]
  (spec/keys :req-un [::base/type]
             :opt-in [::base/user-profile ::base/auth-token]))

(defmethod payload :auth-token [_]
  (spec/keys :req-un [::base/type]
             :opt-in [::base/auth-token]))

(defmethod payload :appstate [_]
  (spec/keys :req-un [::base/type ::appstate/appstate]))

(defmethod payload :auth-token [_]
  (spec/keys :req-un [::base/type ::auth-token]))

(defmethod payload :collection [_]
  (spec/keys :req-un [::base/type ::collections/collection]))

(defmethod payload :course [_]
  (spec/keys :req-un [::base/type ::course]))

(defmethod payload :checkpoint [_]
  (spec/keys :req-un [::base/type ::course]))

(defmethod payload :courses [_]
  (spec/keys :req-un [::base/type ::courses/courses]))

(defmethod payload :resources [_]
  (spec/keys :req-un [::base/type ::resources/resources]))

(spec/def ::payload (spec/multi-spec payload :type))
