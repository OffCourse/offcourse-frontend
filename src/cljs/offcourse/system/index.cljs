(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]
            [offcourse.datastore.index :as datastore]
            [offcourse.logger.index :as logger]
            [offcourse.router.index :as router]
            [offcourse.api.index :as api]
            [offcourse.ui.index :as ui]
            [offcourse.system.interactions :refer [actions reactions]]
            [offcourse.system.routes :refer [routes]]
            [offcourse.system.view-helpers :refer [view-helpers]]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.system.fetchables :refer [fetchables]]
            [offcourse.system.viewmodels :refer [viewmodels]]
            [offcourse.system.views :refer [views]]))


(defn system [bootstrap-docs repositories]
  (let [channels plumbing/channels]
    (component/system-map
     :routes                 routes
     :repositories           repositories
     :viewmodels             viewmodels
     :views                  views
     :view-helpers           (view-helpers routes)
     :fetchables             fetchables
     :api-actions            (:api actions)
     :api-reactions          (:api reactions)
     :api-channels           (:api channels)
     :api                    (component/using (api/new :api)
                                              {:channels     :api-channels
                                               :actions      :api-actions
                                               :fetchables   :fetchables
                                               :reactions    :api-reactions
                                               :repositories :repositories})
     :router-actions         (:router actions)
     :router-reactions       (:router reactions)
     :router-channels        (:router channels)
     :router                 (component/using (router/new)
                                              {:channels  :router-channels
                                               :routes    :routes
                                               :actions   :router-actions
                                               :reactions :router-reactions})
     :logger-actions         (:logger actions)
     :logger-reactions       (:logger reactions)
     :logger-channels        (:logger channels)
     :logger                 (component/using (logger/new)
                                              {:channels  :logger-channels
                                               :actions   :logger-actions
                                               :reactions :logger-reactions})

     :datastore-actions      (:datastore actions)
     :datastore-reactions    (:datastore reactions)
     :datastore-channels     (:datastore channels)
     :datastore              (component/using (datastore/new)
                                              {:channels  :datastore-channels
                                               :actions   :datastore-actions
                                               :reactions :datastore-reactions})
     :appstate-actions       (:appstate actions)
     :appstate-reactions     (:appstate reactions)
     :appstate-channels      (:appstate channels)
     :appstate               (component/using (appstate/new)
                                              {:channels   :appstate-channels
                                               :viewmodels :viewmodels
                                               :actions    :appstate-actions
                                               :reactions  :appstate-reactions})
     :ui-actions             (:ui actions)
     :ui-reactions           (:ui reactions)
     :ui-channels            (:ui channels)
     :ui                     (component/using (ui/new)
                                              {:channels      :ui-channels
                                               :actions       :ui-actions
                                               :view-helpers  :view-helpers
                                               :views         :views
                                               :reactions     :ui-reactions}))))
