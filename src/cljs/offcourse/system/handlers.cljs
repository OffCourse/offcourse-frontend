(ns offcourse.system.handlers
  (:require [bidi.bidi :refer [path-for]]))

(defn handlers []
  (let [add-checkpoint (fn [] (.alert js/window "hola"))]
    {:add-checkpoint add-checkpoint
     :edit-checkpoint add-checkpoint}))
