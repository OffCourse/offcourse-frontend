(ns offcourse.specs.response
  (:require [cljs.spec :as spec]
            [offcourse.specs.appstate :as appstate]
            [offcourse.specs.base :as base]))


(spec/def ::user-profile map?)
(spec/def ::course map?)
(spec/def ::courses (spec/* ::course))
(spec/def ::resource map?)
(spec/def ::resources (spec/* ::resource))

(defmulti response :type)

(defmethod response :user-profile [_]
  (spec/and (spec/keys :req-un [::base/type
                                ::user-profile])))

(defmethod response :courses [_]
  (spec/keys :req-un [::base/type
                      ::courses]))

(defmethod response :course [_]
  (spec/keys :req-un [::base/type
                      ::course]))

(defmethod response :checkpoint [_]
  (spec/keys :req-un [::base/type
                      ::course]))

(defmethod response :resources [_]
  (spec/keys :req-un [::base/type
                      ::resources]))

(spec/def ::response (spec/multi-spec response :type))
