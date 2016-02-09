(ns history-handler
  (:require [compojure.core :refer [GET defroutes]]
            [ring.util.http-response :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer [html]]
            [hiccup.page :refer [html5 include-js include-css]]))

(def index-page
  (slurp "resources/index.html"))

(defroutes app
  (route/resources "/js" {:root "js"})
  (route/resources "/css" {:root "css"})
  (route/resources "/fonts" {:root "fonts"})
  (GET "/" [] (-> (ok index-page) (content-type "text/html")))
  (route/not-found (-> (ok index-page) (content-type "text/html"))))
