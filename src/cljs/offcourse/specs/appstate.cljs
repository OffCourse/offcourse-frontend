(ns offcourse.specs.appstate
  (:require [cljs.spec :as spec]
            [offcourse.specs.courses :as courses]
            [offcourse.specs.base :as base]))

(spec/def ::site-title string?)
(spec/def ::user-name (spec/nilable ::base/user-name))
(spec/def ::user (spec/keys :req-un [::user-name]))
(spec/def ::auth-token (spec/nilable ::base/auth-token))

(spec/def ::appstate (spec/keys :req-un [::site-title
                                         ::viewmodel
                                         ::user
                                         ::auth-token
                                         ::courses/courses
                                         ::resources]))
