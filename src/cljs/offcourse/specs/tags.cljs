(ns offcourse.specs.tags
  (:require [cljs.spec :as spec]))

(spec/def ::tag keyword?)
(spec/def ::tags (spec/* ::tag))
