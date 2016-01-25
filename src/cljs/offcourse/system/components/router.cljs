(ns offcourse.system.components.router
  (:require [com.stuartsierra.component :as component]
            [offcourse.router.index :as router]))

(def actions [:requested-route])

(def routes ["/" {[[keyword :collection-name]] :home-view
                  [[keyword :collection-type] "/" [keyword :collection-name]] :collection-view
                  true  :home-view}])

(def reactions {:home-view        (partial merge {:type :collection-view
                                                  :collection-type :flags
                                                  :collection-name :new})
                :collection-view  (partial merge {:type :collection-view})})

(def component
  (component/using
   (router/new routes actions reactions)
   {:output-channel :router-output
    :log-channel :logger-input}))
