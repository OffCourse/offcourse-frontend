(ns offcourse.models.datastore.helpers)

(defn query [type & args]
  (let [payload (case type
                  :courses (apply hash-map args)
                  :resources (apply hash-map args)
                  {type (apply hash-map args)})]
    (assoc payload :type type)))

(defn true-or-false? [response]
  (false? response))
