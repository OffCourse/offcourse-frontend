(ns offcourse.system.handlers
  (:require [bidi.bidi :refer [path-for]]))

(def handlers
  {:sign-in (fn [responder] (partial responder :requested-sign-in :user))
   :update-appstate (fn [responder] (partial responder :requested-update))
   :save-checkpoint (fn [responder] #(responder :requested-save {:type :checkpoint}))
   :save-course (fn [responder] #(responder :requested-save {:type :course}))})
