(ns offcourse.views.base
  (:require [plumbing.core :refer-macros [fnk]]
            [offcourse.views.containers.app :refer [app]]
            [offcourse.views.components.logo :refer [logo]]
            [offcourse.views.components.actions-panel :refer [actions-panel]]
            [offcourse.views.containers.menubar :refer [menubar]]
            [shared.protocols.validatable :as va]
            [shared.protocols.loggable :as log]))

(def graph
  {:container      (fnk [] app)
   :viewmodel      (fnk [[:appstate viewmodel]] viewmodel)
   :viewmodel-name (fnk [viewmodel] (va/resolve-type viewmodel))
   :user-name      (fnk [] nil)
   :base-actions   (fnk [] [:sign-in :sign-out])
   :actions        (fnk [base-actions] (into #{} base-actions))
   :respond        (fnk [responder actions]
                        (fn [[action-type :as action]]
                          (if (contains? actions action-type)
                            (responder [:requested action])
                            (log/error action-type (str "invalid action")))))
   :logo           (fnk [[:appstate site-title]
                         respond]
                        (logo {:site-title site-title} respond))
   :actions-panel  (fnk [user-name
                         respond]
                        (actions-panel {:user-name user-name}
                                       respond))
   :menubar        (fnk [logo
                         actions-panel
                         viewmodel-name]
                        (menubar logo actions-panel))})
