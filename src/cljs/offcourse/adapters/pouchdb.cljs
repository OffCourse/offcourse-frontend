(ns offcourse.adapters.pouchdb
  (:require [cljs.core.async :refer [<! >! timeout pipe chan]]
            [com.stuartsierra.component :as component]
            [offcourse.adapters.pouchdb.wrapper :as wrapper]
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
    (let [channel (chan)]
      (go
        (let [bootstrap-data {:bootstrap-doc (<! (wrapper/has-doc? connection bootstrap-doc))
                              :design-doc    (<! (wrapper/has-doc? connection design-doc))}
              missing        (reduce (fn [acc [k v]] (when-not v (conj acc k)))
                                     [] bootstrap-data)]
          (if (empty? missing)
            (>! channel {})
            (>! channel {:missing missing}))))
      channel))
  (valid?-async [db]
    (let [channel (chan)]
      (go
        (let [errors (<! (va/errors-async db))]
          (if (empty? errors)
            (>! channel false)
            (>! channel true))))
      channel)))

(defn new-db [name design-doc bootstrap-doc]
  (map->PouchDB {:name name
                 :design-doc design-doc
                 :bootstrap-doc bootstrap-doc}))

(defn bootstrap-data [{:keys [bootstrap-doc design-doc connection]}]
  (let [channel (chan)]
    (go
      (let [bootstrap-data {:bootstrap-doc (<! (wrapper/refresh-doc connection bootstrap-doc))
                            :design-doc    (<! (wrapper/refresh-doc connection design-doc))}
            missing        (reduce (fn [acc [k v]] (when-not v (conj acc k)))
                                   [] bootstrap-data)]
        (if (empty? missing)
          (>! channel "initialized db")
          (>! channel {:missing missing}))))
    channel))

(defn bootstrap [db]
  (let [channel (chan)]
    (go
      (let [errors (<! (va/errors-async db))]
        (if (empty? errors)
          (>! channel "all's well")
          (pipe (bootstrap-data db) channel))))
    channel))
