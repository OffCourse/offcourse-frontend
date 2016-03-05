(ns offcourse.protocols.renderable)

(defprotocol Renderable
  (-render [this] [this query]))

(defn render
  ([component] (-render component))
  ([component query]
   (-render component query)))
