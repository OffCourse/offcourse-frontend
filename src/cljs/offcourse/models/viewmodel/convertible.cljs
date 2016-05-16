(ns offcourse.models.viewmodel.convertible
  (:require [bidi.bidi :as bidi]))

(defmulti to-url (fn [{:keys [type] :as query} _]
                   type))

(defmethod to-url :new-user-view [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes type))

(defmethod to-url :new-course-view [{:keys [type dependencies] :as vm} routes]
  (let [{:keys [course-slug curator] :as course} (:course dependencies)]
    (bidi/path-for routes type :curator curator)))

(defmethod to-url :course-view [{:keys [type dependencies] :as vm} routes]
  (let [{:keys [course-slug curator] :as course} (:course dependencies)]
    (bidi/path-for routes type :curator curator :course-slug course-slug)))

(defmethod to-url :checkpoint-view [{:keys [type dependencies] :as vm} routes]
  (let [{:keys [course-slug curator]} (:course dependencies)
        {:keys [checkpoint-slug]} (:checkpoint dependencies)]
    (bidi/path-for routes type :curator curator :course-slug course-slug :checkpoint-slug checkpoint-slug)))

(defmethod to-url :collection-view [{:keys [type collection] :as vm} routes]
  (let [{:keys [collection-type collection-name]} collection]
    (bidi/path-for routes type :collection-type collection-type :collection-name collection-name)))

(defmethod to-url :loading-view [{:keys [type dependencies] :as vm} routes]
  (bidi/path-for routes type))
