(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]
            [offcourse.logger.index :as logger]
            [offcourse.router.index :as router]
            [offcourse.auth.index :as auth]
            [offcourse.api.index :as api]
            [offcourse.ui.index :as ui]
            [offcourse.models.appstate.index :as appstate-model]
            [offcourse.system.interactions :refer [actions reactions]]
            [offcourse.system.routes :as routes]
            [offcourse.system.handlers :refer [handlers]]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.fetchables :refer [fetchables]]
            [offcourse.system.ui-components :refer [ui-components]]
            [offcourse.system.handlers :refer [handlers]]
            [offcourse.system.views :refer [views]]))


(defn system [site-title repositories auth-config identity-config]
  (let [channels plumbing/channels]
    (component/system-map
     :routes                 routes/table
     :route-responses        routes/responses
     :url-helpers            routes/url-helpers
     :appstate-state         (atom (appstate-model/new {:site-title "Offcourse_"}))
     :repositories           repositories
     :views                  views
     :view-components        ui-components
     :view-handlers          handlers
     :fetchables             fetchables
     :api-actions            (:api actions)
     :api-reactions          (:api reactions)
     :api-channels           (:api channels)
     :api                    (component/using (api/new)
                                              {:channels     :api-channels
                                               :actions      :api-actions
                                               :fetchables   :fetchables
                                               :reactions    :api-reactions
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

     :appstate-actions       (:appstate actions)
     :appstate-reactions     (:appstate reactions)
     :appstate-channels      (:appstate channels)
     :appstate               (component/using (appstate/new)
                                              {:channels  :appstate-channels
                                               :state     :appstate-state
                                               :actions   :appstate-actions
                                               :reactions :appstate-reactions})
     :ui-actions             (:ui actions)
     :ui-reactions           (:ui reactions)
     :ui-channels            (:ui channels)
     :ui                     (component/using (ui/new)
                                              {:channels    :ui-channels
                                               :actions     :ui-actions
                                               :appstate    :appstate-state
                                               :url-helpers :url-helpers
                                               :handlers    :view-handlers
                                               :routes      :routes
                                               :components  :view-components
                                               :views       :views
                                               :reactions   :ui-reactions}))))
