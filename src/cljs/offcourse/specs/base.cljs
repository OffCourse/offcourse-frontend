(ns offcourse.specs.base
  (:require [cljs.spec :as spec]))

(defn user-name-length [str]
  (>= (count str) 3))

(spec/def ::type keyword?)
(spec/def ::user-name (spec/and keyword? #(user-name-length (name %))))
(spec/def ::user-profile (spec/keys :req-un [::user-name]))
(spec/def ::auth-token string?)
(spec/def ::url (spec/and string? #(re-matches #"https?://.*" %)))

