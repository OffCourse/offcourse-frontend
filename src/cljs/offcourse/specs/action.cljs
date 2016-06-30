(ns offcourse.specs.action
  (:require [cljs.spec :as spec]
            [offcourse.specs.payload :as payload]
            [offcourse.specs.base :as base]))

(spec/def ::source keyword?)

(spec/def ::action (spec/keys :req-un [::base/type ::source]
                              :opt-un [::payload/payload]))
