(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.helpers.string :as sh]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

#_(defn fetch-1 [api repository {:keys [type] :as query} converter]
  (go
    (let [result (<! (qa/fetch repository query))]
      (if (:error result)
        (ri/respond api :not-found-data query)
        (ri/respond api :found-data type (converter result))))))

(defn fetch-m [api repository {:keys [type] :as query} converter field]
  (go
    (let [result (remove nil? (<! (qa/fetch repository query)))]
      (if (or (:error result) (empty? result))
        (ri/respond api :not-found-data query)
        (when-let [converted (keep converter result)]
          (ri/respond api :found-data type converted))))))

#_(defn fetch [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (when true #_(= type :resources)
    (if-let [[converter field] (type fetchables)]
      (doseq [{:keys [supported-types] :as repository} repositories]
        (when (some #{type} supported-types)
          (if field
            (fetch-m api repository query converter field)
            (fetch-1 api repository query converter))))
      (ri/respond api :query-not-supported query))))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :collection [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (doseq [repository repositories]
    (go
      (let [result (remove nil? (<! (qa/fetch repository query)))]
        (if (or (:error result) (empty? result))
          (ri/respond api :not-found-data query)
          (when-let [converted (keep ci/to-course result)]
            (ri/respond api :found-data :courses converted)))))))

(defmethod fetch :course [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (doseq [repository repositories]
    (go
      (let [result (<! (qa/fetch repository query))]
        (if (:error result)
          (ri/respond api :not-found-data query)
          (ri/respond api :found-data type (ci/to-course result)))))))
