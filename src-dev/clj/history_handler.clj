(ns history-handler
  (:require [pandeiro.boot-http.impl :refer [wrap-index]]
            [ring.util.response :refer [file-response]]
            [ring.middleware
             [file                   :refer [wrap-file]]
             [resource               :refer [wrap-resource]]]))

(defonce dir "target/dev/")

(defn- handler [request]
  (assoc-in
   (file-response (str dir "index.html"))
   [:headers "Content-Type"]
   "text/html;charset=ISO-8859-1"))

(def app (-> handler
             (wrap-resource "")
             (wrap-file dir {:index-files? false})
             (wrap-index dir)))
