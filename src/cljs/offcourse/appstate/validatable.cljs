(ns offcourse.appstate.validatable
  (:require [offcourse.protocols.validatable :as va]))

(defn valid? [{:keys [state proposal]}]
  (va/valid? @proposal))
