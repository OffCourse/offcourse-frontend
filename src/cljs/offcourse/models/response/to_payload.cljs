(ns offcourse.models.response.to-payload
  (:require [offcourse.models.payload.index :as payload]
            [offcourse.models.response.converters :as cv]
            [offcourse.specs.payload :as pl-spec]
            [offcourse.specs.response :as rs-spec]
            [cljs.spec :as spec]))

(spec/fdef to-payload
           :args (spec/* ::rs-spec/response)
           :ret ::pl-spec/payload)

(defmulti to-payload (fn [{:keys [type]}] type))

(defmethod to-payload :user-profile [{:keys [type user-profile]}]
  (payload/new type (-> user-profile
                        (dissoc :user-id)
                        (update-in [:user-name] #(keyword %)))))

(defmethod to-payload :course [{:keys [type course] :as response}]
  (let [{:keys [curator flags forks checkpoints]} course
        course (cv/to-course course)]
    (payload/new type course)))

(defmethod to-payload :courses [{:keys [type courses] :as response}]
  (payload/new type (keep cv/to-course courses)))

(defmethod to-payload :resources [{:keys [type resources]}]
  (payload/new type (keep cv/to-resource resources)))

(spec/instrument #'to-payload)
