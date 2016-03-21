(ns offcourse.models.course.remove-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [cuerdas.core :as str]
            [offcourse.models.course.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]))

(deftest models-course-delete
  (testing "query type is checkpoint"
    (let [sut (-> (sut/new)
                  (assoc :checkpoints [fx/checkpoint])
                  (qa/remove :checkpoint fx/checkpoint))]
      (is (= (count (:checkpoints sut)) 0)))))

