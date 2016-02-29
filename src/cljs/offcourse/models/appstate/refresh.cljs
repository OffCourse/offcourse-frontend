(ns offcourse.models.appstate.refresh
  (:require [offcourse.models.collection :as cl]
            [medley.core :as medley]
            [com.rpl.specter :refer [select select-first transform filterer ALL]]
            [clojure.set :as set]
            [offcourse.models.datastore.paths :as paths]
            [offcourse.protocols.queryable :as qa]))

(defn deep-merge
  [& vs]
  (if (every? map? vs)
    (apply merge-with deep-merge vs)
    (last vs)))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :appstate [state {:keys [appstate]}]
  (merge state appstate))

(defmethod refresh :store [{:keys [store] :as as} query]
  (update as :store #(qa/refresh % query)))

(defmethod refresh :default [{:keys [store] :as as} query]
  {:type :error :error :query-not-supported})
