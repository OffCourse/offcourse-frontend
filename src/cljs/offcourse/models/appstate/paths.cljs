(ns offcourse.models.appstate.paths
  (:require [offcourse.protocols.queryable :as qa]
            [com.rpl.specter :refer [ALL transform select-first]]
            [cuerdas.core :as str]))

(defn collection [collection-type collection-name]
  [:collections ALL #(and (= (:collection-type %) collection-type)
                          (= (:collection-name %) collection-name))])

(defn course-ids [collection-type collection-name]
  [(collection collection-type collection-name) :course-ids])

(defn course
  ([course-id] [:courses ALL #(= (:course-id %) course-id)])
  ([curator hashtag] [:courses ALL #(and (= (:hashtag %) hashtag)
                                         (= (:curator %) curator))]))

(defn course2
  ([curator goal]
   [:courses ALL #(and (= (:slug %) (str/slugify goal))
                       (= (:curator %) curator))]))

(defn course3
  ([curator slug]
   [:courses ALL #(and (= (:slug %) slug)
                       (= (:curator %) curator))]))

(defn checkpoints [course-id]
  [(course course-id) :checkpoints])

(defn checkpoint [course-id checkpoint-id]
  [(course course-id) :checkpoints ALL #(= (:checkpoint-id %) checkpoint-id)])

(defn resource [url]
  [:resources ALL #(= (:url %) url)])
