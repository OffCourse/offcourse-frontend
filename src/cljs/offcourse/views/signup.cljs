(ns offcourse.views.signup
  (:require [shared.protocols.decoratable :as dc]
            [plumbing.core :refer-macros [fnk]]))

(def graph
  {:user-name  (fnk [appstate] :new)
   :profile     (fnk [appstate]
                     (some-> appstate
                             (get-in [:viewmodel :new-user])
                             dc/decorate))
   :main        (fnk [] nil)
   :actions    (fnk [base-actions]
                    (->> base-actions
                         (into #{})))
   :dashboard   (fnk [profile
                      [:components dashboard user-form]
                      respond]
                     (dashboard {:main (user-form profile respond)}))})
