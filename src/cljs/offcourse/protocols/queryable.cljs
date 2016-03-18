(ns offcourse.protocols.queryable
  (:refer-clojure :exclude [get remove]))

(defprotocol Queryable
  (-get     [this query])
  (-add     [this query])
  (-remove  [this query])
  (-check   [this] [this query])
  (-fetch   [this query])
  (-refresh [this doc]))

(def payloads
  {:collection-names    :collection-type
   :collections         :course
   :collection          :collection
   :courses             :courses
   :course              :course
   :checkpoints         :checkpoints
   :checkpoint          :checkpoint
   :view                :view-data
   :url                 :checkpoint-slug
   :update-curator      :curator
   :resources           :resources
   :resource            :resource})

(defn get
  ([this query] (-get this query))
  ([this type data] (get this {:type           type
                               (type payloads) data})))

(defn fetch [this query]
  (-fetch this query))

(defn refresh
  ([this query] (-refresh this query))
  ([this type data] (-refresh this {:type           type
                                    (type payloads) data})))

(defn add
  ([this query] (-add this query))
  ([this type data] (-add this {:type           type
                                (type payloads) data})))

(defn remove
  ([this query] (-remove this query))
  ([this type data] (-remove this {:type           type
                                (type payloads) data})))

(defn check
  ([this] (-check this))
  ([this query] (-check this query))
  ([this type data] (-check this {:type type
                                  (type payloads) data})))
