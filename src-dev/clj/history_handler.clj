(ns history-handler
  (:require [compojure.core :refer [GET defroutes]]
            [ring.util.http-response :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [html5 include-js include-css]]))

(def index-page
  (html
   (html5
    [:head
     [:title "Offcourse"]
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
     (include-css "/css/table.css")]
    [:body
     [:div#app.app-wrapper
       [:h1 "Waiting for ClojureScript to Compile"]]
     (include-js "/js/app.js")])))

(defroutes app
  (route/resources "/js" {:root "js"})
  (route/resources "/css" {:root "css"})
  (GET "/" []
    (-> (ok index-page) (content-type "text/html")))
  (route/not-found (-> (ok index-page) (content-type "text/html"))))
