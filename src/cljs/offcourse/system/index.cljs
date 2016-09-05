(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.api.index :as api]
            [offcourse.appstate.index :as appstate]
            [offcourse.auth.index :as auth]
            [offcourse.router.index :as router]
            [offcourse.protocol-extensions.decoratable]
            [offcourse.protocol-extensions.loggable]
            [offcourse.protocol-extensions.convertible]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.routes :as routes]
            [offcourse.system.views :refer [views]]
            [offcourse.ui.index :as ui]))

(defn connect-to-repository [{:keys [adapter] :as config}]
  (component/start (adapter config)))


(defn system [appstate repositories auth-config]
  (let [channels plumbing/channels]
    (component/system-map
     :repositories           (map connect-to-repository (:query repositories))
     :api-channels           (:api channels)
     :api-triggers           [:not-found]
     :api-responses          [:found :not-found :failed]
     :api                    (component/using (api/create :api)
                                              {:channels     :api-channels
                                               :triggers     :api-triggers
                                               :responses    :api-responses
                                               :repositories :repositories})
     :auth-channels           (:auth channels)
     :auth-triggers           [:requested]
     :auth-responses          [:granted :revoked]
     :auth-config             auth-config
     :auth                    (component/using (auth/create :auth)
                                               {:channels  :auth-channels
                                                :triggers  :auth-triggers
                                                :responses :auth-responses
                                                :config    :auth-config})

     :routes                 routes/table
     :router-triggers        [:refreshed]
     :router-responses       [:requested]
     :router-channels        (:router channels)
     :router                 (component/using (router/create :router)
                                              {:channels           :router-channels
                                               :triggers           :router-triggers
                                               :responses          :router-responses
                                               :routes             :routes})
     :appstate-atom          appstate
     :appstate-triggers      [:granted  :requested :found :not-found]
     :appstate-responses     [:refreshed :updated :requested :not-found]
     :appstate-channels      (:appstate channels)
     :appstate               (component/using (appstate/create :appstate)
                                              {:channels  :appstate-channels
                                               :triggers  :appstate-triggers
                                               :responses :appstate-responses
                                               :state     :appstate-atom})


     :views                  views
     :ui-triggers            [:refreshed]
     :ui-responses           [:rendered :requested]
     :ui-channels            (:ui channels)
     :ui                     (component/using (ui/create :ui)
                                              {:channels    :ui-channels
                                               :triggers    :ui-triggers
                                               :responses   :ui-responses
                                               :routes      :routes
                                               :views       :views}))))
