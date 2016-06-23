(ns offcourse.protocols.queryable
  (:refer-clojure :exclude [get -reset remove])
  (:require [offcourse.models.payload :as payload]))

(defprotocol Queryable
  (-get     [this query])
  (-add     [this query])
  (-remove  [this query])
  (-check   [this] [this query])
  (-fetch   [this query])
  (-refresh [this] [this doc]))

(defn get
  ([this query] (-get this query))
  ([this type data] (get this (payload/new type data))))

(defn fetch
  ([this query] (-fetch this query))
  ([this type data]
   (-fetch this (payload/new type data))))

(defn refresh
  ([this] (-refresh this))
  ([this query] (-refresh this query))
  ([this type data] (-refresh this (payload/new type data))))

(defn add
  ([this query] (-add this query))
  ([this type data] (-add this (payload/new type data))))

(defn remove
  ([this query] (-remove this query))
  ([this type data] (-remove this (payload/new type data))))

(defn check
  ([this] (-check this))
  ([this query] (-check this query))
  ([this type data] (-check this (payload/new type data))))
