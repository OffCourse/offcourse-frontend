(ns offcourse.appstate.queryable
  (:require [offcourse.protocols.composable :as ca]
            [offcourse.appstate.appstore :as store]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.responsive :as ri]))

(defn refresh [{:keys [proposed] :as as} {:keys [type] :as query}]
  (reset! proposed (store/new query))
  (let [missing-data  (-> (ca/compose as)
                          (va/missing-data))]
    (ri/respond as :not-found-data missing-data)))
