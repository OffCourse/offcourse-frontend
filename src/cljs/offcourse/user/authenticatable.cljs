(ns offcourse.user.authenticatable
  (:require [cljs.core.async :refer [<! chan close! >!]]
            [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [offcourse.protocols.authenticable :as ac :refer [Authenticable]]
            [gapi]
            [schema.core :as schema])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

(defn load-gapi-auth2 []
  (let [c (chan)]
    (.load js/gapi "auth2" #(go (>! c true)))
    c))

(defn auth-instance []
  (.getAuthInstance js/gapi.auth2))

(defn get-google-token []
  (-> (auth-instance) .-currentUser .get .getAuthResponse .-id_token))

(defn handle-user-change
  [user u]
  (when-let [profile (.getBasicProfile u)]
    (println "HO")
    (let [user-name (keyword (.getName profile))
          email   (.getEmail profile)
          token (get-google-token)]
      (if token
        (ri/respond user :refreshed-user :user {:name user-name})
        (ri/respond user :refreshed-user :user {:name nil})))))

(defn init [user]
  (go
    (<! (load-gapi-auth2))
    (.init js/gapi.auth2
           (clj->js {"client_id" "916200543092-1l4drfqvifc1l57djumde0vls81iktru.apps.googleusercontent.com"
                     "scope"     "profile"}))
    (let [current-user (.-currentUser (auth-instance))]
      (.listen current-user (partial handle-user-change user)))))

(defn sign-in []
          (.signIn (auth-instance)))

(defn sign-out [] (.signOut (auth-instance)))
