(ns offcourse.protocols.queryable)

(defprotocol Queryable
  (fetch [this query]))
