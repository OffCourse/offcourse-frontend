(ns offcourse.data-service.validatable
  (:require [offcourse.protocols.validatable :as va]))

(defn valid? [{:keys [store]}]
  (va/valid? @store))
