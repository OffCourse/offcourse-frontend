(ns offcourse.adapters.fakedb.implementations.queryable
  (:require [com.rpl.specter :refer [ALL select select-first]]
            [offcourse.adapters.fakedb.collections :as cl]
            [offcourse.adapters.fakedb.courses :as cs]
            [cljs.core.async :refer [<! chan close! >!]]
            [clojure.walk :as walk]
            [ajax.core :refer [GET]]
            [offcourse.adapters.fakedb.resources :as r])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defonce courses   (cs/courses))
(defonce all-resources (r/resources courses))
(defonce collections (cl/collections courses))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :collection [_ {:keys [collection]}]
  (when-let [{:keys [collection-name collection-type]} collection]
    (go {:collection-name collection-name
         :collection-type collection-type
         :course-ids (get-in collections [collection-type collection-name])})))

(defmethod fetch :course [_ {:keys [course]}]
  (go
    (if-let [course (or (cs/course-by-id course courses)
                        (cs/course-by-curator-and-slug course courses))]
      course
      {:error :not-found-data})))

(defmethod fetch :courses [_ {:keys [course-ids]}]
  (go
    (if-let [courses (cs/courses-by-id course-ids courses)]
      courses
      {:error :not-found-data})))

(defmethod fetch :resource [_ {:keys [url]}]
  (go (r/select-resource url all-resources)))

(defn parse-response [res]
  (:title (select-keys (walk/keywordize-keys (js->clj res)) [:title :content :description])))

(defn get-resource [url]
  (let [c (chan)]
    (GET (str "http://api.embed.ly/1/extract?key=5406650948f64aeb9102b9ea2cb0955c&url=" url "&maxwidth=500")
        {:handler #(go (>! c %))})
    c))

(defmethod fetch :resources [_ {:keys [resources tags]}]
  (let [urls (map :url resources)]
    (go
      (println (parse-response (<! (get-resource (rand-nth urls)))))
      (if tags
        all-resources
        (r/select-resources urls all-resources)))))
