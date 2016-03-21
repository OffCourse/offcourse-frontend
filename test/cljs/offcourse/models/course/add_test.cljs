(ns offcourse.models.course.add-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.course.index :as sut]
            [offcourse.models.fixtures :as fx]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-course-add
    (testing "query type is not supported"
      (is (= (qa/get (sut/new) :bla {}) {:type :error :error :query-not-supported})))

    (testing "query type is checkpoint"

      (let [sut (-> (sut/new)
                    (assoc :checkpoints [{:checkpoint-id 0}])
                    (qa/add :checkpoint fx/checkpoint))]
        (is (= (count (:checkpoints sut)) 2)))

      (let [sut (-> (sut/new)
               (assoc :checkpoints [fx/checkpoint])
               (qa/add :checkpoint fx/checkpoint))]
        (is (= (count (:checkpoints sut)) 1)))))
