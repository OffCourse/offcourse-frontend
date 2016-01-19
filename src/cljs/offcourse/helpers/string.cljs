(ns offcourse.helpers.string)

(defn remove-from-end [s end]
  (if (.endsWith s end)
    (.substring s 0 (- (count s)
                       (count end)))
    s))

(defn singular [field]
  (-> field
      name
      (remove-from-end "s")
      keyword))
