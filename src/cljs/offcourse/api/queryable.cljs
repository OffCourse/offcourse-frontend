(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :collection [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (doseq [repository repositories]
    (go
      (let [result (remove nil? (<! (qa/fetch repository query)))]
        (if (or (:error result) (empty? result))
          (ri/respond api :not-found-data query)
          (when-let [converted (keep ci/to-course result)]
            (ri/respond api :found-data :courses converted)))))))

(defmethod fetch :course [{:keys [repositories fetchables] :as api} {:keys [course] :as query}]
  (doseq [repository repositories]
    (go
      (let [result (<! (qa/fetch repository query))]
        (when-not (:error result)
          (ri/respond api :found-data :course (ci/to-course result)))))))
