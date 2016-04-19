(ns offcourse.models.checkpoint.refresh
  (:require [cuerdas.core :as str]))

(defmulti refresh (fn [_ {:keys [type]}] type))

(defmethod refresh :url [checkpoint {:keys [url]}]
  (assoc checkpoint :url url))

(defmethod refresh :task [checkpoint {:keys [task]}]
  (assoc checkpoint
         :task (str/titleize task)
         :checkpoint-slug (str/slugify task)))
