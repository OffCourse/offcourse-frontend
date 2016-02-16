(ns offcourse.protocols.renderable)

(defprotocol Renderable
  (-render [this viewmodel]))

(defn render [component viewmodel]
  (-render component viewmodel))
