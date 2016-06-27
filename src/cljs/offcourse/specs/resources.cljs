(ns offcourse.specs.resources
  (:require [cljs.spec :as spec]
            [offcourse.specs.base :as base]
            [offcourse.specs.tags :as tags]
            [offcourse.specs.checkpoints :as checkpoints]))

(spec/def ::description string?)
(spec/def ::title string?)
(spec/def ::author string?)
(spec/def ::authors (spec/* ::author))
(spec/def ::content string?)
(spec/def ::resource (spec/keys :req-un [::base/url ::checkpoints/tasks ::tags/tags]
                                 :opt-un [::base/type
                                          ::description
                                          ::title
                                          ::authors
                                          ::content]))
