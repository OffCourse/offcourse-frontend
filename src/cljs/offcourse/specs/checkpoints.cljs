(ns offcourse.specs.checkpoints
  (:require [cljs.spec :as spec]
            [offcourse.specs.tags :as tags]
            [offcourse.specs.base :as base]))


(spec/def ::checkpoint-id int?)
(spec/def ::completed? (spec/or :undefined nil? :false false? :true int?))
(spec/def ::task string?)
(spec/def ::checkpoint (spec/keys :req-un [::completed?
                                           ::base/url
                                           ::task
                                           ::tags/tags]
                                  :opt-un [::checkpoint-id]))

(spec/def ::checkpoints (spec/+ ::checkpoint))
