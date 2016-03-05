(ns offcourse.views.base
  (:require [plumbing.core :refer-macros [fnk]]))

(def graph
  {:container (fnk [[:components app]] app)
   :view-data (fnk [appstate] (:view-data appstate))
   :view-name (fnk [appstate] (:view-type appstate))
   :menubar   (fnk [[:appstate site-title]
                    [:url-helpers home-url]
                    [:components logo menubar]]
                   (menubar {:logo    (logo site-title home-url)
                             :actions {}}))})
