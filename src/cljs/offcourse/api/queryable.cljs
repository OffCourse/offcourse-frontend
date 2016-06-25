(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<!]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn fetch [{:keys [repositories] :as api} {:keys [type] :as query}]
  (doseq [{:keys [resources] :as repository} repositories]
    (when (contains? resources type)
      (go
        (let [response (<! (qa/fetch repository query))]
          (match response
                 {:error _} (ri/respond api :not-found-data query)
                 {:type _}  (ri/respond api :found-data (ci/to-payload response))))))))
