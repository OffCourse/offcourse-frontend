(ns offcourse.specs.response
  (:require [cljs.spec :as spec]
            [offcourse.specs.appstate :as appstate]
            [offcourse.specs.base :as base]))

(defmulti response :type)

(defmethod response :user-profile [_]
  (spec/keys :req-un [::base/type]))

(defmethod response :courses [_]
  (spec/keys :req-un [::base/type]))

(defmethod response :course [_]
  (spec/keys :req-un [::base/type]))

(defmethod response :checkpoint [_]
  (spec/keys :req-un [::base/type]))

(defmethod response :resources [_]
  (spec/keys :req-un [::base/type]))

(spec/def ::response (spec/multi-spec response :type))
