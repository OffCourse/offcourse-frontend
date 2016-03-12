(ns offcourse.models.appstate.helpers
  (:require [offcourse.models.appstate.index :as as]))

(defn falsy? [response]
  (or (nil? response) (false? response)))

(defn contains-val? [collection val]
  (boolean (some #{val} collection)))

(defn collection ([type name] {:collection-type type
                               :collection-name name}))

(defn appstate [view-type & data-deps]
  {:type :appstate
   :appstate (apply as/new view-type data-deps)})

(defn course-by-id [id] {:course-id id})

(defn course-by-hashtag [curator hashtag] {:curator curator
                                           :hashtag hashtag})

(defn course-by-goal [curator goal] {:curator curator
                                     :goal goal})

(defn course-by-slug [curator slug] {:curator curator
                                     :course-slug slug})

(defn checkpoint ([course-id checkpoint-id] {:course-id course-id
                                             :checkpoint-id checkpoint-id}))

(defn checkpoint-by-slug ([course-id checkpoint-slug] {:course-id course-id
                                                       :checkpoint-slug checkpoint-slug}))

(defn resource ([id] {:resource-id  id
                      :url id}))
