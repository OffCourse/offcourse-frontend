(ns offcourse.system.index
  (:require [com.stuartsierra.component :as component]
            [offcourse.appstate.index :as appstate]
            [offcourse.datastore.index :as datastore]
            [offcourse.logger.index :as logger]
            [offcourse.router.index :as router]
            [offcourse.api.index :as api]
            [offcourse.renderer.index :as renderer]
            [offcourse.system.interactions :refer [actions reactions]]
            [offcourse.system.routes :refer [routes]]
            [offcourse.system.plumbing :as plumbing]
            [offcourse.protocols.convertible :as ci]
            [offcourse.system.viewmodels :refer [viewmodels]]))

(def fetchables
  {:courses            [ci/to-course :course-ids]
   :course             [ci/to-course]
   :collection         [ci/to-collection]
   :collection-names   [identity]
   :resources          [ci/to-resource :resource-ids]
   :resource           [ci/to-resource]})

(defn system [bootstrap-docs repositories]
  (let [channels plumbing/channels]
    (component/system-map
     :routes                 routes
     :repositories           repositories
     :viewmodels             viewmodels
     :fetchables             fetchables
     :api-actions            (:api actions)
     :api-reactions          (:api reactions)
     :api-channels           (:api channels)
     :api                    (component/using (api/new :api)
                                              {:channels   :api-channels
                                               :actions    :api-actions
                                               :fetchables :fetchables
                                               :reactions  :api-reactions
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
     :renderer-actions       (:renderer actions)
     :renderer-reactions     (:renderer reactions)
     :renderer-channels      (:renderer channels)
     :renderer               (component/using (renderer/new)
                                              {:channels       :renderer-channels
                                               :actions        :renderer-actions
                                               :reactions      :renderer-reactions}))))
