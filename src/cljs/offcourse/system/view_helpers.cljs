(ns offcourse.system.view-helpers
  (:require [bidi.bidi :refer [path-for]]))

(defn view-helpers [routes]
  (let [create-url     (partial path-for routes)
        collection-url (fn [collection-type collection-name]
                         (create-url :collection-view
                                     :collection-type collection-type
                                     :collection-name collection-name))
        checkpoint-url (fn [curator hashtag checkpoint-id]
                         (create-url :checkpoint-view
                                     :curator curator
                                     :hashtag hashtag
                                     :checkpoint-id checkpoint-id))
        home-url       (collection-url :flags :featured)
        add-checkpoint (fn [] (.alert js/window "hola"))]
    {:create-url     create-url
     :home-url       home-url
     :collection-url collection-url
     :add-checkpoint add-checkpoint
     :checkpoint-url checkpoint-url}))
