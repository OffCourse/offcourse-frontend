(ns offcourse.protocols.queryable
  (:refer-clojure :exclude [get]))

(defprotocol Queryable
  (-get     [this query])
  (-add     [this query])
  (-modify  [this query])
  (-check   [this] [this query])
<<<<<<< HEAD
  (-fetch   [this query])
  (-refresh [this doc]))
=======
  (fetch   [this query])
  (refresh [this doc]))

>>>>>>> b0f61bca632fb81094e7cfb4a96acd99ee387a6b

(def payloads
  {:collection-names    :collection-type
   :collection          :collection
   :courses             :course-ids
   :course              :course
   :checkpoint          :checkpoint
   :resources           :resource-ids
   :resource            :resource})

(defn get
  ([this query] (-get this query))
  ([this type data] (get this {:type           type
                               (type payloads) data})))

(defn fetch [this query]
  (-fetch this query))

(defn modify
  ([this query] (-modify this query)))

(defn refresh
  ([this query] (-refresh this query))
  ([this type data] (-refresh this {:type           type
                                    (type payloads) data})))

(defn add
  ([this query] (-add this query))
<<<<<<< HEAD
  ([this type data] (-add this {:type           type
                                (type payloads) data})))

(defn check
  ([this] (-check this))
  ([this query] (-check this query))
  ([this type data] (-check this {:type type
                                  (type payloads) data})))
=======
  ([this type data]
   (-add this {:type           type
              (type payloads) data})))

(defn check
  ([this] (-check this))
  ([this query]
   (-check this query))
  ([this type data]
   (-check this {:type type
                 (type payloads) data})))
>>>>>>> b0f61bca632fb81094e7cfb4a96acd99ee387a6b
