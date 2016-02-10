(ns offcourse.styles.index
  (:require [garden.def :refer [defstyles]]
            [offcourse.styles
             [components :refer [components]]
             [config :refer [config]]
             [global :refer [global]]
             [layout :refer [layout]]
             [typography :refer [typography]]]))

(defstyles base
  (let [modules [global typography layout components]]
    (for [module modules] (module config))))
