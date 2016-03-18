(ns offcourse.models.course.remove
  (:refer-clojure :exclude [remove])
  (:require [offcourse.models.checkpoint :as cp]
            [cljs.core :as core]
            [cuerdas.core :as str]
            [offcourse.protocols.queryable :as qa]))

(defn remove [course {:keys [checkpoints] :as query}]
  (let [{:keys [checkpoint-slug]} (first checkpoints)]
    (update course :checkpoints (fn [checkpoints]
                                  (core/remove #(= (:checkpoint-slug %) checkpoint-slug)
                                               checkpoints)))))
