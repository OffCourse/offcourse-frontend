(ns offcourse.cloud.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [AWS]
            [offcourse.cloud.refresh :as refresh-impl]
            [offcourse.cloud.queryable :as qa-impl]
            [offcourse.cloud.add :as add-impl]
            [offcourse.cloud.reset :as reset-impl]
            [offcourse.cloud.sync :as sync-impl]
            [offcourse.cloud.get :as get-impl]
            [ajax.core :refer [GET POST]]
            [cljs.core.async :refer [<! chan >!]]
            [schema.core :as schema]
            [clojure.walk :as walk]
            [offcourse.helpers.converters :as cvs]
            [offcourse.models.course.index :as co])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)

(defn response->courses [c response]
  (let [items (-> response
                  (js->clj)
                  walk/keywordize-keys
                  :Items)
        courses (map cvs/to-course items)]
  (go (>! c courses))))

(defn fetch-course [query]
  (let [c (chan)]
    (POST (str "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/staging/courses")
        {:headers {}
         :params (clj->js query)
         :format :json
         :handler #(go (>! c %)) #_(response->courses c %)})
  c))

(schema/defrecord Cloud
    [component-name :- schema/Keyword
     initial-config
     config]
  Lifecycle
  (start [cloud]
    (go
      (qa/reset cloud)
      (<! (qa/get cloud {:type :dataset}))
      (ri/listen cloud)))
  (stop [cloud] (ri/mute cloud))
  Queryable
  (-get [cloud query] (get-impl/get cloud query))
  (-add [cloud query] (add-impl/add cloud query))
  (-refresh [cloud query] (refresh-impl/refresh cloud query))
  (-fetch [cloud query] (qa-impl/fetch cloud query))
  (-reset [cloud] (reset-impl/reset cloud))
  (-sync [cloud] (sync-impl/sync cloud))
  Responsive
  (-respond [user status payload] (ri/respond user status payload))
  (-respond [user status type result] (ri/respond user status type result))
  (-mute [user] (ri/mute user))
  (-listen  [user] (ri/listen user)))

(defn new [] (map->Cloud {:component-name :cloud
                          :profile-data (atom nil)}))
