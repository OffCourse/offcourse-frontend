(ns offcourse.views.base
  (:require [rum.core :as rum]
            [plumbing.core :refer-macros [fnk]]))


(def graph
  {:container     (fnk [[:components app]] app)
   :user-name     (fnk [[:appstate user]] (:name user))
   :view-data     (fnk [appstate] (-> appstate :viewmodel :dependencies))
   :view-name     (fnk [appstate view-data] (:type view-data))
   :base-actions  (fnk [] {})
   :actions       (fnk [base-actions view-actions] (merge base-actions view-actions))
   :menubar       (fnk [user-name
                        actions
                        [:appstate site-title]
                        [:url-helpers home-url profile-url]
                        handlers
                        [:components actions-panel sign-in-panel logo menubar]]
                       (menubar {:logo          (logo site-title home-url)
                                 :action-panel  (actions-panel actions)
                                 :sign-in-panel (sign-in-panel user-name (:sign-in handlers)
                                                               profile-url)}))})


