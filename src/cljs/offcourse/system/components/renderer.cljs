(ns offcourse.system.components.renderer
  (:require [offcourse.renderer.index :as renderer]
            [com.stuartsierra.component :as component]
            [offcourse.views.debug :as debug]
            [offcourse.protocols.rendering :as rr]))

(def actions [:rendered-view])

(def reactions {:composed-viewmodel rr/render})

(def component
  (component/using
   (renderer/new actions reactions debug/debugger)
   {:input-channel :renderer-input}))
