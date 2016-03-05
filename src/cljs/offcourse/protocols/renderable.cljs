(ns offcourse.protocols.renderable)

(defprotocol Renderable
  (-render [this] [this query]))

(defn render
  ([component] (-render component))
  ([component viewmodel]
   (-render component query)))
