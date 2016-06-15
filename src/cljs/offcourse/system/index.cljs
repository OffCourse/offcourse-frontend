(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.api.index :as api]
            [offcourse.appstate.index :as appstate]
            [offcourse.auth.index :as auth]
            [offcourse.router.index :as router]
            [offcourse.system.handlers :refer [handlers]]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.routes :as routes]
            [offcourse.system.ui-components :refer [ui-components]]
            [offcourse.system.views :refer [views]]
            [offcourse.ui.index :as ui]))

(defn system [site-title repositories auth-config cloud-config]
  (let [channels plumbing/channels]
    (component/system-map
     :repositories           repositories
     :api-channels           (:api channels)
     :api                    (component/using (api/new)
                                              {:channels     :api-channels
                                               :repositories :repositories})
     :auth-channels           (:auth channels)
     :auth-config             auth-config
     :auth                    (component/using (auth/new)
                                              {:channels     :auth-channels
                                               :auth-config  :auth-config})

     :routes                 routes/table
     :route-responses        routes/responses
     :router-channels        (:router channels)
     :router                 (component/using (router/new)
                                              {:channels  :router-channels
                                               :routes    :routes
                                               :responses :route-responses})
     :appstate-channels      (:appstate channels)
     :appstate               (component/using (appstate/new)
                                              {:channels  :appstate-channels})

     :views                  views
     :view-components        ui-components
     :view-handlers          handlers
     :url-helpers            routes/url-helpers
     :ui-channels            (:ui channels)
     :ui                     (component/using (ui/new)
                                              {:channels    :ui-channels
                                               :url-helpers :url-helpers
                                               :handlers    :view-handlers
                                               :routes      :routes
                                               :components  :view-components
                                               :views       :views}))))
