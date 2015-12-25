(ns adapters.pouchdb.index
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [com.stuartsierra.component :as component]
            [adapters.pouchdb.wrapper :as wrapper]
            [offcourse.protocols.validatable :as va :refer [Validatable]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defrecord PouchDB [name design-doc bootstrap-doc connection]
  component/Lifecycle
  (start [db]
    (assoc db :connection (wrapper/init (:name db))))
  (stop [db]
    (dissoc db :connection))
  Validatable
  (errors-async [{:keys [connection design-doc bootstrap-doc]}]
    (go
      (let [bootstrap-data [design-doc bootstrap-doc]
            missing        (<! (wrapper/missing-docs connection bootstrap-data))]
        (if (empty? missing)
          {:status :db-ready}
          {:status :error
           :error  :missing-data
           :missing-data missing}))))
  (valid?-async [db]
    (go
      (let [{:keys [status]} (<! (va/errors-async db))]
        (if (= status :error) false true)))))

(defn new-db [name design-doc bootstrap-doc]
  (map->PouchDB {:name name
                 :design-doc design-doc
                 :bootstrap-doc bootstrap-doc}))

(defn bootstrap-data [{:keys [bootstrap-doc design-doc connection]}]
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
        false
        true))))
