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

(spec/def ::proper-checkpoint (spec/and ::checkpoint #(base/proper? % [:tags])))
(spec/def ::raw-checkpoint (spec/and ::checkpoint #(base/raw? % [:tags])))

(spec/def ::checkpoints (spec/or :proper (spec/* ::proper-checkpoint)
                                 :raw (spec/* ::raw-checkpoint)))
