(ns offcourse.specs.collections
  (:require [cljs.spec :as spec]))

(spec/def ::collection-type keyword?)
(spec/def ::collection-name keyword?)
(spec/def ::collection (spec/keys :req-un [[::collection-type ::collection-name]]))
