(ns offcourse.views.base
  (:require [rum.core :as rum]
            [plumbing.core :refer-macros [fnk]]))


(def graph
  {:container     (fnk [[:components app]] app)
   :user-name     (fnk [[:appstate user]]
                       (:user-name user))
   :base-actions  (fnk [] {})
   :actions       (fnk [] {})
   :menubar       (fnk [user-name
                        base-actions
                        actions
                        [:appstate site-title]
                        [:url-helpers home-url profile-url]
                        [:handlers sign-in sign-out]
                        [:components actions-panel logo menubar]]
                       (menubar {:logo          (logo site-title home-url)
                                 :action-panel  (actions-panel (merge base-actions actions)
                                                               user-name
                                                               sign-in
                                                               sign-out
                                                               profile-url)}))})
