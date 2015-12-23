(ns offcourse.fake-data.implementations.available
  (:require [offcourse.protocols.taggable :as tb]
            [offcourse.protocols.available :refer [Available]]))

(defmulti has?
  (fn [selector _ _] selector))

(defmethod has? :tag [_ course tag]
  (let [tags (tb/get-tags course)]
    (contains? tags (keyword tag))))

(defmethod has? :flag [_ {:keys [flags]} flag]
  (contains? flags flag))

(defmethod has? :user [_ {:keys [curator]} user]
  (= (keyword curator) user))

(extend-protocol Available
  PersistentArrayMap
  (has? [this selector field]
    (has? selector this field)))
