(ns offcourse.models.datastore.paths
  (:require [offcourse.protocols.queryable :as qa]
            [com.rpl.specter :refer [ALL transform select-first]]))

(defn course
  ([course-id] [:courses ALL #(= (:course-id %) course-id)])
  ([curator hashtag] [:courses ALL #(and (= (:hashtag %) hashtag)
                                         (= (:curator %) curator))]))

(defn checkpoints [course-id]
  [(course course-id) :checkpoints])

(defn checkpoint [course-id checkpoint-id]
  [(course course-id) :checkpoints ALL #(= (:checkpoint-id %) checkpoint-id)])
