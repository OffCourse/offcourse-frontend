(ns offcourse.appstate.index
  (:require [com.stuartsierra.component :refer [Lifecycle]]
            [offcourse.appstate.react :as react-impl]
            [shared.protocols.responsive :as ri :refer [Responsive]]))

(defrecord Appstate []
  Lifecycle
  (start   [as] (ri/listen as))
  (stop    [as] (ri/mute as))
  Responsive
  (-respond [as event] (ri/respond as event))
  (-mute [as] (ri/mute as))
  (-react [as event] (react-impl/react as event))
  (-listen [as] (ri/listen as)))

(defn create [name] (-> {:component-name name}
                        map->Appstate))
