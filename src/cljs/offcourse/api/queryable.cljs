(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def conversions
  {:user-profile ci/to-user-profile
   :course       ci/to-course
   :courses      (partial keep ci/to-course)
   :resources    (partial keep ci/to-resource)})

(defn fetch [{:keys [repositories] :as api} {:keys [type] :as query}]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources type)
      (go
        (let [{:keys [type error] :as result} (<! (qa/fetch repository query))]
          (if-not error
            (ri/respond api :found-data type ((type conversions) (type result)))
            (ri/respond api :not-found-data {:type type})))))))
