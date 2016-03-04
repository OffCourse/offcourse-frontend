(ns offcourse.views.base
  (:require [plumbing.core :refer-macros [fnk]]))

(def graph
  {:container (fnk [[:components app]] app)
   :view-data (fnk [appstate] (:view-data appstate))
   :view-name (fnk [appstate] (:view-type appstate))
   :menubar   (fnk [helpers [:components logo menubar]]
                   (menubar {:logo    (logo helpers)
                             :actions [(:new-course-url helpers)]}))})
