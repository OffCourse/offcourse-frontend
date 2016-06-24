(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def conversions
  {:user-profile ci/to-user-profile
   :course       ci/to-course
   :courses      ci/to-courses
   :resources    ci/to-resources})

(defn handle-success [api {:keys [type] :as response}]
  (ri/respond api :found-data type ((type conversions) (type response))))

(defn handle-error [api query]
  (ri/respond api :not-found-data query))

(defn fetch [{:keys [repositories] :as api} {:keys [type] :as query}]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources type)
      (go
        (let [response (<! (qa/fetch repository query))]
          (match response
                 {:error _} (handle-error api query)
                 {:type _}  (handle-success api response)))))))
