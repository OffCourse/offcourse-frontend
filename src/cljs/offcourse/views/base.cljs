(ns offcourse.views.base
  (:require [plumbing.core :refer-macros [fnk]]))

(def graph
  {:container (fnk [[:components app]] app)
   :view-data (fnk [appstate] (:view-data appstate))
   :view-name (fnk [appstate] (:view-type appstate))
   :menubar   (fnk [[:appstate user site-title]
                    [:url-helpers home-url]
                    handlers
                    [:components logo menubar]]
                   (menubar {:logo    (logo site-title home-url)
                             :user-name (:name user)
                             :actions (select-keys handlers [:sign-in])}))})
