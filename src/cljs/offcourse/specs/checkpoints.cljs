(ns offcourse.specs.checkpoints
  (:require [cljs.spec :as spec]
            [offcourse.specs.tags :as tags]
            [offcourse.specs.base :as specs]))


(spec/def ::checkpoint-id int?)
(spec/def ::completed? (spec/or :undefined nil? :false false? :true int?))
(spec/def ::url (spec/and string? #(re-matches #"https?://.*" %)))
(spec/def ::task string?)
(spec/def ::checkpoint (spec/keys :req-un [::completed?
                                           ::url
                                           ::task
                                           ::tags/tags]
                                  :opt-un [::checkpoint-id]))

(spec/def ::checkpoints (spec/+ ::checkpoint))
