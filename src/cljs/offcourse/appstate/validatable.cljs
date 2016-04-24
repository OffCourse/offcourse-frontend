(ns offcourse.appstate.validatable
  (:require [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa]))

(defn valid? [{:keys [state proposal]}]
  (and (va/valid? @proposal) (not (= @state @proposal))))
