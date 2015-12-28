(ns offcourse.protocols.queryable)

(defprotocol Queryable
  (check [this query])
  (fetch [this query])
  (refresh [this doc]))
