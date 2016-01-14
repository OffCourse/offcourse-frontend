(ns offcourse.appstate.composable
  (:require [offcourse.protocols.composable :as ca]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.responsive :as ri]))

(defn compose
  ([{:keys [proposed viewmodels] :as as}]
   (let [{:keys [type] :as view} (:view @proposed)]
     ((type viewmodels) view)))
  ([{:keys [proposed] :as as} {:keys [store]}]
   (let [viewmodel    (-> (ca/compose as)
                          (qa/refresh store))
         missing-data (va/missing-data viewmodel)]
     (if missing-data
       (ri/respond as :not-found-data missing-data)
       (ri/respond as :composed-viewmodel {:viewmodel viewmodel})))))
