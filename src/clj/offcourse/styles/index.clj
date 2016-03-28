(ns offcourse.styles.index
  (:require [garden.def :refer [defstyles]]
            [offcourse.styles
             [config :refer [config]]
             [global :refer [global]]
             [layout :refer [layout]]
             [typography :refer [typography]]]
            [offcourse.styles.components.index :refer [components]]))

(defstyles base
  (let [modules [global typography layout components]]
    (for [module modules] (module config))))
