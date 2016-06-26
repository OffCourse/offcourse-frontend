(ns offcourse.models.specs
  (:require [offcourse.protocols.queryable :as qa :refer [Queryable]]
            [offcourse.protocols.validatable :as va :refer [Validatable]]
            [cljs.spec :as spec]
            [cuerdas.core :as str]))

(spec/def ::user-name (spec/and keyword? #(>= (count (name %)) 3)))
(spec/def ::user-profile (spec/keys :req-un [::user-name]))

(spec/def ::tag keyword?)
(spec/def ::tags (spec/* ::tag))

(spec/def ::checkpoint-id int?)
(spec/def ::completed? (spec/or :undefined nil? :false false? :true int?))
(spec/def ::url string?)
(spec/def ::task string?)
(spec/def ::checkpoint (spec/keys :req-un [::completed?
                                           ::url
                                           ::task
                                           ::tags]
                                  :opt-un [::checkpoint-id]))

(spec/def ::course-id string?)
(spec/def ::curator ::user-name)
(spec/def ::base-id ::course-id)
(spec/def ::goal string?)
(spec/def ::course-slug string?)
(spec/def ::flags set?)
(spec/def ::version (spec/* int?))
(spec/def ::revision int?)
(spec/def ::forked-from (spec/or :course-id ::course-id :root nil))
(spec/def ::forks (spec/and set? (spec/* ::course-id)))
(spec/def ::checkpoints (spec/+ ::checkpoint))
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
                                       ::checkpoints]))
(spec/def ::courses (spec/* ::course))

(spec/def ::collection-type keyword?)
(spec/def ::collection-name keyword?)
(spec/def ::collection (spec/keys :req-un [[::collection-type ::collection-name]]))


(spec/def ::type keyword?)
(spec/def ::source keyword?)
(spec/def ::auth-token string?)
(spec/def ::payload (spec/or :data (spec/keys :req-un [::type]
                                              :opt-un [::user-profile
                                                       ::auth-token
                                                       ::collection
                                                       ::courses])
                             :empty nil?))

(spec/def ::action (spec/keys :req-un [::type ::source ::payload]))
