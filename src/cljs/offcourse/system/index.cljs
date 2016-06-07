(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]
            [offcourse.logger.index :as logger]
            [offcourse.router.index :as router]
            [offcourse.auth.index :as auth]
            [offcourse.cloud.index :as cloud]
            [offcourse.api.index :as api]
            [offcourse.ui.index :as ui]
            [offcourse.models.appstate.index :as appstate-model]
            [offcourse.system.interactions :refer [actions reactions]]
            [offcourse.system.routes :as routes]
            [offcourse.system.handlers :refer [handlers]]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.ui-components :refer [ui-components]]
            [offcourse.system.handlers :refer [handlers]]
            [offcourse.system.views :refer [views]]))


(defn system [site-title repositories auth-config cloud-config]
  (let [channels plumbing/channels]
    (component/system-map
     :cloud-config           cloud-config
     :cloud-actions          (:cloud actions)
     :cloud-reactions        (:cloud reactions)
     :cloud-channels         (:cloud channels)
     :cloud                  (component/using (cloud/new)
                                              {:initial-config :cloud-config
                                               :channels     :cloud-channels
                                               :actions      :cloud-actions
                                               :reactions    :cloud-reactions})
     :routes                 routes/table
     :route-responses        routes/responses
     :url-helpers            routes/url-helpers
     :repositories           repositories
     :views                  views
     :view-components        ui-components
     :view-handlers          handlers
     :api-channels           (:api channels)
     :api                    (component/using (api/new)
                                              {:channels     :api-channels
                                               :repositories :repositories})
     :auth-actions            (:auth actions)
     :auth-reactions          (:auth reactions)
     :auth-channels           (:auth channels)
     :auth-config             auth-config
     :auth                    (component/using (auth/new)
                                              {:channels     :auth-channels
                                               :auth-config  :auth-config
                                               :actions      :auth-actions
                                               :reactions    :auth-reactions})
     :router-actions         (:router actions)
     :router-reactions       (:router reactions)
     :router-channels        (:router channels)
     :router                 (component/using (router/new)
                                              {:channels  :router-channels
                                               :routes    :routes
                                               :responses :route-responses
                                               :actions   :router-actions
                                               :reactions :router-reactions})
     :logger-actions         (:logger actions)
     :logger-reactions       (:logger reactions)
     :logger-channels        (:logger channels)
     :logger                 (component/using (logger/new)
                                              {:channels  :logger-channels
                                               :actions   :logger-actions
                                               :reactions :logger-reactions})

     :appstate-channels      (:appstate channels)
     :appstate               (component/using (appstate/new)
                                              {:channels  :appstate-channels})
     :ui-actions             (:ui actions)
     :ui-reactions           (:ui reactions)
     :ui-channels            (:ui channels)
     :ui                     (component/using (ui/new)
                                              {:channels    :ui-channels
                                               :actions     :ui-actions
                                               :url-helpers :url-helpers
                                               :handlers    :view-handlers
                                               :routes      :routes
                                               :components  :view-components
                                               :views       :views
                                               :reactions   :ui-reactions}))))
