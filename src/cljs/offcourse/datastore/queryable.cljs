(ns offcourse.datastore.queryable
  (:require [offcourse.protocols.responsive :refer [respond]]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defmulti check (fn [_ {:keys [type]}] type))

(defmethod check :view [{:keys [store] :as ds} query]
  (println query))

(defmethod check :default [{:keys [store] :as ds} query]
  (if (qa/check @store query)
    (respond ds :checked-store {:store @store})
    (respond ds :not-found-data query)))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :view [{:keys [store] :as ds} {:keys [view] :as query}]
  (println (-> (qa/refresh @store query)
               (qa/check)))
  #_(respond ds :not-found-data {:type (:type view)
                               (:type view) (:view-data view)}))

(defmethod refresh :default [{:keys [store] :as ds} query]
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
