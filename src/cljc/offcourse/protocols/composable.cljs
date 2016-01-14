(ns offcourse.protocols.composable)

(defprotocol Composable
    (compose [this] [this store]))
