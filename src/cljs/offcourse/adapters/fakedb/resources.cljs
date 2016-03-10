(ns offcourse.adapters.fakedb.resources
  (:require [clojure.string :as str]
            [com.rpl.specter :refer [ALL select transform select-first]]
            [offcourse.adapters.fakedb.helpers :as h]))

(defn resource-path [url] [ALL #(= (:url %) url)])

(defn select-resource [url resources]
  (select-first [(resource-path url)] resources))

(defn select-resources [urls resources]
  (map #(select-resource % resources) urls))

(defn dummy [{:keys [url task] :as checkpoint}]
  (let [title (h/make-title)
        content (h/make-text title)]
    {:url     url
     :type    :markdown
     :title   title
     :tasks   {task 0}
     :authors nil
     :tags    (h/set-of-buzzwords 1 5)
     :content content}))

(defn resources [courses]
  (let [checkpoints (mapcat :checkpoints courses)]
    (reduce (fn [resources {:keys [url task] :as checkpoint}]
              (if (select-resource url resources)
                (transform [(resource-path url) :tasks]
                           (fn [tasks]
                             (if (get tasks task)
                               (update tasks task inc)
                               (assoc tasks task 0)))
                           resources)
                (conj resources (dummy checkpoint)))) [] checkpoints)))


