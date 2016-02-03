(ns offcourse.adapters.pouchdb.implementations.queryable.fetch
  (:require [cljs.core.async :refer [<!]]
            [wrappers.pouchdb :as wrapper])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defmulti fetch
  (fn [_ {:keys [type]}] type))

(defmethod fetch :doc [connection {:key key}]
  (wrapper/get-doc connection keys))

(defmethod fetch :docs [connection query]
  (wrapper/all-docs connection query))

(defmethod fetch :course [connection {:keys [course-id]}]
  (let [options {:key course-id
                 :reduce false
                 :include_docs true}
        cb       (comp doall first (partial map :doc))]
    (wrapper/query connection options cb :courseIds)))

(defmethod fetch :courses [connection {:keys [course-ids]}]
  (let [options {:keys course-ids
                 :reduce false
                 :include_docs true}
        cb       (partial map :doc)]
  (wrapper/query connection options cb :courseIds)))

(defmethod fetch :collection [connection {:keys [collection]}]
  (when-let [{:keys [collection-name collection-type]} collection]
    (let [options  {:reduce false
                    :key collection-name}
          collection {:collection-name collection-name
                      :collection-type collection-type}
          cb       (comp (partial assoc collection :course-ids)
                         (partial into #{} (map :value)))]
      (wrapper/query connection options cb collection-type))))

(defmethod fetch :collection-names [connection _]
  (let [options       {:group true}
        cb            (partial into #{} (map #(keyword (:key %1))))
        extract-names (partial wrapper/query connection options cb)]
    (go
      {:flags    (<! (extract-names :flags))
       :tags     (<! (extract-names :tags))
       :curators (<! (extract-names :curators))})))
