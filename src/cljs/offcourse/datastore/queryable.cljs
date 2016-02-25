(ns offcourse.datastore.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defn check [{:keys [store] :as ds} query]
  (if (qa/check @store query)
    (if (va/valid? ds)
      (respond ds :checked-store {:store @store})
      (respond ds :not-found-data {:type :collection-names})))
    (respond ds :not-found-data query))

(defn refresh [{:keys [store] :as ds} query]
  (let [old-store @store]
    (do
      (swap! store #(qa/refresh % query))
      (when-not (= old-store @store)
        (if (va/valid? @store)
          (respond ds :refreshed-store {:store @store})
          (respond ds :not-found-data {:type :collection-names}))))))

(defn add [{:keys [store] :as ds} query]
  (swap! store #(qa/add % query))
  (if (va/valid? ds)
    (respond ds :checked-store {:store @store})
    (respond ds :not-found-data {:type :collection-names})))
