(ns adapters.pouchdb.implementations.bootstrappable
  (:require [cljs.core.async :refer [<!]]
            [adapters.pouchdb.implementations.validatable :as va]
            [adapters.pouchdb.wrapper :as wrapper])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn- bootstrap-data [{:keys [bootstrap-doc design-doc connection]}]
  (go
    (let [bootstrap-data {:bootstrap-doc (<! (wrapper/refresh-doc connection bootstrap-doc))
                          :design-doc    (<! (wrapper/refresh-doc connection design-doc))}
          missing        (reduce (fn [acc [k v]] (when-not v (conj acc k)))
                                 [] bootstrap-data)]
      (if (empty? missing)
        {:status :db-bootstrapped}
        {:status :error
         :error :missing-data
         :missing-data missing}))))

(defn bootstrap [db]
           (go
             (let [valid? (<! (va/valid?-async db))]
               (if-not valid?
                 (<! (bootstrap-data db))
                 true))))
