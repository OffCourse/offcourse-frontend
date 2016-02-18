(ns offcourse.system.handlers
  (:require [bidi.bidi :refer [path-for]]))


(def handlers
  {:add-checkpoint (fn [responder course-id] (responder course-id))})
