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

   :add-new-checkpoint (fn [responder] #(request-update responder {:type :add-new-checkpoint}))

   :remove-checkpoint (fn [responder] #(request-update responder {:type :remove-checkpoint
                                                                  :checkpoint %}))
   :add-tag    (fn [responder] (fn [event]
                                 (.preventDefault event)
                                 (request-update responder {:type :add-tag})))

   :toggle-checkpoint    (fn [responder] (fn [course-id checkpoint event]
                                           (.preventDefault event)
                                           (request-update responder {:type :toggle-checkpoint
                                                                      :course {:course-id course-id}
                                                                      :checkpoint checkpoint})))

   :save-profile    (fn [responder] (fn [event]
                                  (.preventDefault event)
                                   (responder :requested-save {:type :profile})))

   :save-course (fn [responder] (fn [event]
                                  (.preventDefault event)
                                  (responder :requested-save {:type :new-course})))})
