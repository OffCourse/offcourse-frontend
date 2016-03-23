(ns offcourse.models.checkpoint.add-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]))

(deftest models-checkpoint-add
  (testing "query contains tag"
    (let [checkpoint (qa/add fx/checkpoint {:type :tag
                                            :tag fx/other-buzzword})]
      (is (contains? (-> checkpoint :tags) fx/other-buzzword)))))
