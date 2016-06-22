(ns offcourse.protocols.redirectable)

(defprotocol Redirectable
  (-redirect [this destination] [this destination payload]))

(defn redirect
  ([this destination] (-redirect this destination))
  ([this destination payload] (-redirect this destination payload)))
