(ns offcourse.models.datastore.valid
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]))

(defn query [[type data]]
  {:type type
   type data})

(defn valid? [{:keys [appstate] :as ds}]
  (and (va/valid? appstate)
       (every? #(qa/check ds (query %)) (:data-deps appstate))))
