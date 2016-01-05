(ns offcourse.adapters.pouchdb.implementations.queryable.refresh
  (:require [cljs.core.async :refer [<!]]
            [wrappers.pouchdb :as wrapper])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti refresh
  (fn [_ {:keys [type]}] type))

(defmethod refresh :docs [{:keys [connection]} {:keys [docs]}]
  (wrapper/bulk-docs connection docs))
