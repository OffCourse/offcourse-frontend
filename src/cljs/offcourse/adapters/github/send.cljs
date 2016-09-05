(ns offcourse.adapters.github.send
  (:require [ajax.core :refer [GET]]
            [cljs.core.async :as async :refer [<! chan]]
            cljsjs.js-yaml
            [clojure.walk :as walk]
            [shared.models.event.index :as event])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn respond [{:keys [name]} res]
  (event/create [name :fetched res]))

(defn yaml-file? [path]
  (re-find #"\.yaml$" path))

(defn tree-url [{:keys [endpoint repository]}]
  (let [{:keys [organization name sha]} repository]
    (str endpoint "/repos/" organization "/" name "/git/trees/" sha)))

(defn content-url [{:keys [endpoint repository]} path]
  (let [{:keys [organization name sha]} repository]
    (str endpoint "/repos/" organization "/" name "/contents/" path)))

(defn handle-content [res]
  (->> res
       walk/keywordize-keys
       :content
       (.atob js/window)
       (.safeLoad js/jsyaml)
       js->clj
       walk/keywordize-keys))

(defn handle-tree [tree]
  (->> tree
       walk/keywordize-keys
       :tree
       (map :path)
       (filter yaml-file?)))

(defn handle-response [c res]
  (async/put! c res)
  (async/close! c))

(defn fetch [url]
  (let [c (chan)]
    (GET url
        {:format :json
         :handler #(handle-response c %)})
    c))

(defn send [{:keys [name repository endpoint] :as adapter} [_ query :as event]]
  (let [c (chan)
        auth-token ""
        tree-url (tree-url adapter)]
    (go
      (let [tree (<! (fetch tree-url))
            paths (handle-tree tree)
            content-urls (map #(content-url adapter %) paths)
            query-chans (async/merge (map fetch content-urls))
            raw-content (<! (async/into [] query-chans))
            content (map handle-content raw-content)
            complete (map #(assoc %1
                                  :curator (or (:curator %1) (:curator repository))
                                  :organization (or (:organization %1) (:organization repository))) content)]
        (async/put! c (respond adapter complete))))
    c))
