(ns offcourse.views.signup
  (:require [offcourse.models.course.index :as co]
            [offcourse.models.label :as lb]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.validatable :as va]
            [plumbing.core :refer-macros [fnk]]
            [offcourse.protocols.decoratable :as dc]))

(def graph
  {:user-name  (fnk [appstate] :new)
   :profile     (fnk [appstate]
                     (some-> appstate
                         (get-in [:viewmodel :new-user])
                         dc/decorate))
   :main        (fnk [] nil)
   :actions     (fnk [] nil)
   :dashboard   (fnk [profile [:components dashboard user-form] handlers]
                     (dashboard {:main (user-form profile handlers)}))})

