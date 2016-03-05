(ns offcourse.protocols.authenticable)

(defprotocol Authenticable
  (-authenticate [this query]))

(defn authenticate [this query]
  (-authenticate this query))
