(ns offcourse.appstate.check
  (:require [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :refer [respond]]))

(defn check [{:keys [queries state] :as as} query]
  (if (set/subset? queries #{(hash query)})
    (qa/refresh as {:type :loading-view})
    (respond as :not-found-data query)))
