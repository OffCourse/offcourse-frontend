(ns offcourse.protocols.queryable
  (:refer-clojure :exclude [get]))

(defprotocol Queryable
  (get     [this query])
  (check   [this] [this query])
  (fetch   [this query])
  (refresh [this doc]))
