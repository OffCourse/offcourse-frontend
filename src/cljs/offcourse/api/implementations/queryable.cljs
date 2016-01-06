(ns offcourse.api.implementations.queryable
  (:require [cljs.core.async :refer [<!]]
            [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
(:require-macros [cljs.core.async.macros :refer [go]]))

(defn remove-from-end [s end]
  (if (.endsWith s end)
    (.substring s 0 (- (count s)
                       (count end)))
    s))

(defn singular [field]
  (-> field
      name
      (remove-from-end "s")
      keyword))

(defn missing [requested result field query]
  (let [field-singular (singular field)
        requested (into #{} (field query))
        found (into #{} (map field-singular result))
        missing (set/difference requested found)]
    (if (empty? missing) false (into [] missing))))

(defmulti fetch
  (fn [_ {:keys [type]} & args]
      (case (count args)
        1 :single
        2 :multiple
        type)))

(defmethod fetch :courses    [api query] (fetch api query ci/to-course :course-ids))
(defmethod fetch :course     [api query] (fetch api query ci/to-course))
(defmethod fetch :collection [api query] (fetch api query ci/to-collection))
(defmethod fetch :default    [api query] (fetch api query identity))

(defmethod fetch :single [{:keys [service] :as api} {:keys [type] :as query} converter]
  (go
    (let [result (<! (qa/fetch service query))]
      (if (:error result)
        (ri/respond api :not-found-data query)
        (ri/respond api :fetched-data type (converter result))))))

(defmethod fetch :multiple [{:keys [service] :as api} {:keys [type] :as query} converter field]
  (go
    (let [result (<! (qa/fetch service query))
          converted (map converter result)
          missing? (missing query converted field query)]
      (if missing?
        (ri/respond api :not-found-data (assoc query field missing?))
        (ri/respond api :fetched-data type converted)))))
