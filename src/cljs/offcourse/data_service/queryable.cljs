(ns offcourse.data-service.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defn check [{:keys [store] :as ds} query]
  (if (qa/check @store query)
    (when (va/valid? ds)
      (respond ds :checked-store {:store @store}))
    (respond ds :not-found-data query)))

(defn refresh [{:keys [store] :as ds} query]
  (do
    (swap! store #(qa/refresh % query))
    (when (va/valid? @store)
      (respond ds :refreshed-datastore {:store @store}))))
