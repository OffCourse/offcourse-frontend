(ns offcourse.models.payload.to-url
  (:require [bidi.bidi :as bidi]
            [cljs.spec :as spec]
            [offcourse.specs.payload :as pl-spec]))

(spec/fdef to-url
           :args (spec/cat :payload ::pl-spec/payload
                           :rest ::spec/any)
           :ret string?)

(defmulti to-url (fn [{:keys [type] :as payload} _] type))

(defmethod to-url :signup [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes :new-user-view))

(defmethod to-url :new-course [{:keys [type new-course] :as vm} routes]
  (bidi/path-for routes :new-course-view :curator (:curator new-course)))

(defmethod to-url :course [{:keys [type course] :as vm} routes]
  (let [{:keys [course-slug curator]} course]
    (bidi/path-for routes :course-view :curator curator :course-slug course-slug)))

(defmethod to-url :checkpoint [{:keys [type course checkpoint] :as vm} routes]
  (let [{:keys [course-slug curator]} course
        {:keys [checkpoint-slug]} checkpoint]
    (bidi/path-for routes :checkpoint-view :curator curator :course-slug course-slug :checkpoint-slug checkpoint-slug)))

(defmethod to-url :collection [{:keys [type collection] :as vm} routes]
  (let [{:keys [collection-type collection-name]} collection]
    (bidi/path-for routes :collection-view :collection-type collection-type :collection-name collection-name)))

(defmethod to-url :loading [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes type))

#_(spec/instrument #'to-url)
