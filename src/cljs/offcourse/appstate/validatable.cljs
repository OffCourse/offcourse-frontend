(ns offcourse.appstate.validatable
  (:require [offcourse.protocols.validatable :as va]))

(defn valid? [{:keys [state proposal]}]
  (and (va/valid? @proposal) (not (= @state @proposal))))
