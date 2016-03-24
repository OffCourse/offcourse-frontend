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
     :tasks   {task 1}
     :checkpoint-count 1
     :authors nil
     :tags    (h/set-of-buzzwords 1 5)
     :content content}))

(defn compare-values [key1 key2 tasks]
  (compare [(get tasks key2) key2]
           [(get tasks key1) key1]))

(defn sort-tasks [{:keys [tasks] :as resource}]
  (->> tasks
       (into (sorted-map-by #(compare-values %1 %2 tasks)))
       keys
       shuffle
       (into #{})
       (assoc resource :tasks)))

(defn set-or-update-tasks [tasks task]
  (if (get tasks task)
    (update tasks task inc)
    (assoc tasks task 0)))

(defn update-resource [resource task]
  (-> resource
      (update :tasks #(set-or-update-tasks %1 task))
      (update :checkpoint-count inc)))

(defn create-or-update-resource [resources {:keys [url task] :as checkpoint}]
  (if (select-resource url resources)
    (transform [(resource-path url)] #(update-resource %1 task) resources)
    (conj resources (dummy checkpoint))))

(defn resources [courses]
  (->> (mapcat :checkpoints courses)
       (reduce create-or-update-resource [])
       (map sort-tasks)
       (sort-by :checkpoint-count)
       reverse))
