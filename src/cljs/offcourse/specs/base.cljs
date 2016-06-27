(ns offcourse.specs.base
  (:require [cljs.spec :as spec]))

(spec/def ::type keyword?)
(spec/def ::user-name (spec/and keyword? #(>= (count (name %)) 3)))
(spec/def ::user-profile (spec/keys :req-un [::user-name]))
(spec/def ::auth-token string?)
(spec/def ::url (spec/and string? #(re-matches #"https?://.*" %)))
