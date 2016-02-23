(ns offcourse.models.datastore.helpers)

(defn falsy? [response]
  (or (nil? response) (false? response)))

(defn contains-val? [collection val]
  (boolean (some #{val} collection)))

<<<<<<< HEAD
(defn collection [type name] {:collection-type type
                              :collection-name name})
=======
(defn collection ([type name] {:collection-type type
                               :collection-name name}))
>>>>>>> b0f61bca632fb81094e7cfb4a96acd99ee387a6b

(defn course
  ([id] {:course-id id})
  ([curator hashtag] {:curator curator
                      :hashtag hashtag}))

<<<<<<< HEAD
(defn checkpoint [course-id checkpoint-id] {:course-id course-id
                                            :checkpoint-id checkpoint-id})

(defn resource [id] {:resource-id id})
=======
(defn checkpoint ([course-id checkpoint-id] {:course-id course-id
                                             :checkpoint-id checkpoint-id}))

(defn resource ([id] {:resource-id id}))
>>>>>>> b0f61bca632fb81094e7cfb4a96acd99ee387a6b
