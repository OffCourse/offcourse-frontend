(ns offcourse.models.datastore.helpers)

(defn query [type & args]
  (let [payload (case type
                  :courses (apply hash-map args)
                  :resources (apply hash-map args)
                  {type (apply hash-map args)})]
    (assoc payload :type type)))

(defn falsy? [response]
  (or (nil? response) (false? response)))

(defn contains-val? [collection val]
  (boolean (some #{val} collection)))

(defn checkpoint
  [course-id checkpoint-id] {:course-id course-id
                             :checkpoint-id checkpoint-id})

(defn course
  ([id] {:course-id id})
  ([curator hashtag] {:curator curator
                      :hashtag hashtag}))

(defn resource ([id] {:resource-id id}))


(defn collection ([type name] {:collection-type type
                               :collection-name name}))

(defn checkpoint ([course-id checkpoint-id] {:course-id course-id
                                             :checkpoint-id checkpoint-id}))
