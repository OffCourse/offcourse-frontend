(ns offcourse.adapters.fakedb.resources
  (:require [clojure.string :as str]
            [com.rpl.specter :refer [ALL select select-first]]
            [offcourse.adapters.fakedb.helpers :as h]))

(defn dummy [url]
  (let [title (h/make-title)
        content (h/make-text title)]
    {:url     url
     :type    :markdown
     :title   title
     :authors nil
     :tags    (h/set-of-buzzwords 1 5)
     :content content}))

(defn urls [courses]
  (->> courses
       (mapcat :checkpoints)
       (map :url)
       (into #{})))

(defn resources [courses]
  (->> courses
       urls
       (map dummy)))

(defn resource-path [url] [ALL #(= (:url %) url)])

(defn select-resource [url resources]
  (select-first [(resource-path url)] resources))

(defn select-resources [urls resources]
  (map #(select-resource % resources) urls))
