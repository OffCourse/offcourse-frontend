(ns offcourse.specs.courses
  (:require [cljs.spec :as spec]
            [offcourse.specs.base :as base]
            [offcourse.specs.checkpoints :as checkpoints]))

(spec/def ::course-id string?)
(spec/def ::curator ::base/user-name)
(spec/def ::base-id ::course-id)
(spec/def ::goal string?)
(spec/def ::course-slug string?)
(spec/def ::flags (spec/or :raw (spec/* string?)
                           :proper set?))
(spec/def ::version (spec/* int?))
(spec/def ::revision int?)
(spec/def ::forked-from (spec/or :course-id ::course-id :root nil))

(spec/def ::forks (spec/or :empty empty?
                           :raw (spec/* ::course-id)
                           :proper (spec/and set? (spec/* ::course-id))))

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

(spec/def ::raw-course (spec/and ::course #(base/raw? % [:curator :forks :flags :checkpoints])))
(spec/def ::proper-course (spec/and ::course #(base/proper? % [:curator :forks :flags :checkpoints])))

(spec/def ::courses (spec/or :raw (spec/* ::raw-course)
                             :proper (spec/* ::proper-course)))

(spec/def ::raw-courses (spec/and ::courses #(base/raw? % [:courses])))
(spec/def ::proper-courses (spec/and ::courses #(base/proper? % [:courses])))
