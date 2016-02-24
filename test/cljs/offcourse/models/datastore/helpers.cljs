(ns offcourse.models.datastore.helpers
  (:require [clojure.set :as set]))

(defn falsy? [response]
  (or (nil? response) (false? response)))

(defn contains-val? [collection val]
  (boolean (some #{val} collection)))

(defn collection ([type name] {:collection-type type
                               :collection-name name}))

(defn course
  ([id] {:course-id id})
  ([curator hashtag] {:curator curator
                      :hashtag hashtag}))

(defn checkpoint ([course-id checkpoint-id] {:course-id course-id
                                             :checkpoint-id checkpoint-id}))

(defn resource ([id] {:resource-id id}))
