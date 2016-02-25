(ns offcourse.ui.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.models.view :as view]
            [offcourse.protocols.renderable :as rr :refer [Renderable]]
            [offcourse.protocols.responsive :as ri :refer [Responsive]]
            [rum.core :as rum]
            [schema.core :as schema]
            [medley.core :as medley]
            [offcourse.models.datastore.index :as ds]
            [offcourse.protocols.validatable :as va]
            [offcourse.protocols.queryable :as qa]))

(defn augment-handler [component status handler]
  (let [base-handler (partial ri/respond component)]
    [status (partial handler base-handler)]))

(schema/defrecord UI
    [component-name :- schema/Keyword
     channels       :- {}
     route-helpers  :- {}
     handlers       :- {}
     views          :- {}
     viewmodels     :- {}
     actions        :- []
     reactions      :- {}]
  Lifecycle
  (start [rd]
    (let [rd (assoc rd :handlers (medley/map-kv #(augment-handler rd %1 %2) handlers))]
      (ri/listen rd)))
  (stop [rd] (ri/mute rd))
  Renderable
  (-render [{:keys [views route-helpers handlers viewmodels] :as rd} {:keys [state store] :as q}]
    (let [constructor ((get-in state [:view :type]) viewmodels)
          viewmodel   (constructor {:appstate  state
                                    :datastore (or store (ds/new))})
          viewmodel   (dissoc viewmodel :collection-data
                              :tags
                              :resource-id
                              :course-ids
                              :view-data)]
      (if (va/valid? viewmodel)
        (let [view (view/new viewmodel route-helpers handlers views)]
          (rum/mount (rr/render view) (. js/document (getElementById "container")))
          (ri/respond rd :rendered-view))
        (ri/respond rd :not-found-data (va/missing-data viewmodel)))))


  Responsive
  (listen [rd] (assoc rd :listener (ri/-listen rd)))
  (mute [rd] (dissoc rd :listener))
  (respond [rd status] (ri/-respond rd status nil))
  (respond [rd status payload] (ri/-respond rd status payload)))

(defn new []
  (map->UI {:component-name :ui}))
