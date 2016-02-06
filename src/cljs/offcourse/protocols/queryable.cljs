(ns offcourse.protocols.queryable
  (:refer-clojure :exclude [get]))

(defprotocol Queryable
  (-get     [this query])
  (check   [this] [this query])
  (fetch   [this query])
  (refresh [this doc]))


(def payloads
  {:collection-names    :collection-type
   :collection          :collection
   :courses             :course-ids
   :course              :course
   :resources           :resource-ids
   :resource            :resource})


(defn get
  ([this query]
   (-get this query))
  ([this type data]
   (get this {:type           type
              (type payloads) data})))
