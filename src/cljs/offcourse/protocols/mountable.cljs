(ns offcourse.protocols.mountable)

(defprotocol Mountable
  (-mount [this dom-element]))

(defn mount [this dom-element]
  (-mount this dom-element))
