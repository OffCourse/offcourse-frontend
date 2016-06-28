(ns offcourse.specs.courses
  (:require [cljs.spec :as spec]
            [offcourse.specs.base :as base]
            [offcourse.specs.checkpoints :as checkpoints]))

(spec/def ::course-id string?)
(spec/def ::curator ::base/user-name)
(spec/def ::base-id ::course-id)
(spec/def ::goal string?)
(spec/def ::course-slug string?)
(spec/def ::flags set?)
(spec/def ::version (spec/* int?))
(spec/def ::revision int?)
(spec/def ::forked-from (spec/or :course-id ::course-id :root nil))
(spec/def ::forks (spec/and set? (spec/* ::course-id)))

(spec/def ::course (spec/keys :req-un [::course-id
                                       ::base-id
                                       ::course-slug
                                       ::curator
                                       ::flags
                                       ::goal
                                       ::version
                                       ::revision
                                       ::forks
                                       ::forked-from
                                       ::checkpoints/checkpoints]))

(spec/def ::course-data (spec/keys :req-un [::course-slug
                                            ::curator]))

(spec/def ::courses (spec/* ::course))
