(ns offcourse.protocols.composable)

(defprotocol Composable
    (-compose [this] [this views]))

(defn compose [this views]
  (-compose this views))
