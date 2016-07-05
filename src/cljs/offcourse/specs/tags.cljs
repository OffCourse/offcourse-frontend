(ns offcourse.specs.tags
  (:require [cljs.spec :as spec]))

(spec/def ::tag (spec/or :raw string?
                         :proper keyword?))

(spec/def ::raw-tag (spec/and ::tag #(= :raw (first %))))
(spec/def ::proper-tag (spec/and ::tag #(= :proper (first %))))

(spec/def ::tags (spec/or :empty empty?
                          :raw (spec/* ::raw-tag)
                          :proper (spec/* ::proper-tag)))
