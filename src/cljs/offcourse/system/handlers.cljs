(ns offcourse.system.handlers
  (:require [bidi.bidi :refer [path-for]]))

(defn request-update [responder message]
  (responder :requested-update message))

(def handlers
  {:sign-in (fn [responder] (partial responder :requested-sign-in))

   :sign-out (fn [responder] (partial responder :requested-sign-out))

   :update-tag (fn [responder] #(request-update responder {:type :update-tag
                                                           :tag (-> % .-target .-value)}))

   :update-url (fn [responder] #(request-update responder {:type :update-url
                                                           :url (-> % .-target .-value)}))

   :update-task (fn [responder] #(request-update responder {:type :update-task
                                                            :task (-> % .-target .-value)}))

   :update-goal (fn [responder] #(request-update responder {:type :update-goal
                                                            :goal (-> % .-target .-value)}))

   :update-user-name (fn [responder] #(request-update responder {:type :update-user-name
                                                                 :user-name (-> % .-target .-value)}))

   :add-checkpoint (fn [responder] #(request-update responder {:type :add-checkpoint
                                                               :checkpoint %}))

   :save-checkpoint (fn [responder] #(responder :requested-save {:type :checkpoint}))

   :delete-checkpoint (fn [responder] #(request-update responder {:type :delete-checkpoint
                                                                  :checkpoint %}))
   :save-tag    (fn [responder] (fn [event]
                                  (.preventDefault event)
                                  (responder :requested-save {:type :tag})))

   :save-profile    (fn [responder] (fn [event]
                                  (.preventDefault event)
                                   (responder :requested-save {:type :profile})))

   :save-course (fn [responder] #(responder :requested-save {:type :course}))})
