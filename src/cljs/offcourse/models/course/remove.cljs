(ns offcourse.models.course.remove
  (:refer-clojure :exclude [remove])
  (:require [cljs.core :as core]))

(defn remove [course {:keys [checkpoint] :as query}]
  (let [{:keys [checkpoint-slug]} checkpoint]
    (update course :checkpoints (fn [checkpoints]
                                  (core/remove #(= (:checkpoint-slug %) checkpoint-slug)
                                               checkpoints)))))
