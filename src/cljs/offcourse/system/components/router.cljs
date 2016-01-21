(ns offcourse.system.components.router
  (:require [com.stuartsierra.component :as component]
            [offcourse.router.index :as router]))

(def component
  (component/using
   (router/new)
   {:output-channel :router-output}))
