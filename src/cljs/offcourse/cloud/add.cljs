(ns offcourse.cloud.add
  (:refer-clojure :exclude [get])
  (:require [cljs.core.async :refer [<! chan >!]]
            [AWS]
            [medley.core :as medley]
            [offcourse.protocols.responsive :as ri]
            [offcourse.protocols.queryable :as qa]
            [offcourse.views.helpers :as vh]
            [offcourse.models.collection :as cl])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def AWS js/AWS)

(defn add-profile [{:keys [profile-data]} profile-json]
  (let [c (chan)]
    (.put @profile-data "profile" profile-json #(go (>! c %2)))
    c))

(defn add-course [course]
  (let [c (chan)
        payload  (.stringify js/JSON (clj->js course))]
    (.makeRequest (AWS.Lambda.) "invoke" (clj->js {:FunctionName "yaml-s3-development"
                                                   :Payload payload})
                  #(go (>! c %2)))
    c))

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :course [cloud query]
  (go
    (<! (add-course query))
    (ri/respond cloud :requested-view (vh/collection-view (cl/new :flags :featured)))))

(defmethod add :profile [cloud {:keys [profile] :as query}]
  (let [profile-json(->> profile
                         clj->js
                         (.stringify js/JSON))]
    (go
      (<! (add-profile cloud profile-json))
      (ri/respond cloud :requested-view (vh/collection-view (cl/new :flags :featured)))
      (qa/get cloud query))))
