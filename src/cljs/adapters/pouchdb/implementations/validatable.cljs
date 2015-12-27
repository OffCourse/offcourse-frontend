(ns adapters.pouchdb.implementations.validatable
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [adapters.pouchdb.wrapper :as wrapper])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn- errors-async [{:keys [connection design-doc bootstrap-doc]}]
  (go
    (let [bootstrap-data [design-doc bootstrap-doc]
          missing (<! (wrapper/missing-docs connection bootstrap-data))]
      (if (empty? missing)
        {:status :db-ready}
        {:status :error
         :error  :missing-data
         :missing-data missing}))))

(defn valid?-async [db]
  (go
    (let [{:keys [status]} (<! (errors-async db))]
      (if (= status :error) false true))))
