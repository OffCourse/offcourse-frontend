(ns offcourse.protocols.renderable)

(defprotocol Renderable
  (-render [this] [this viewmodel]))

(defn render
  ([component] (-render component))
  ([component viewmodel]
   (-render component viewmodel)))
