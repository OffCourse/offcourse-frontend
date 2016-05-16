(ns offcourse.system.fetchables
  (:require [offcourse.protocols.convertible :as ci]))

(def fetchables
  {:courses            [ci/to-course :course-ids]
   :course             [ci/to-course]
   :collection         [ci/to-course :course-ids]
   :collection-names   [identity]
   :resources          [ci/to-resource :resource-ids]
   :resource           [ci/to-resource]})
