(ns offcourse.models.checkpoint.refresh-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.checkpoint.index :as sut]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-checkpoint-refresh
  (testing "query contains task"
    (let [checkpoint (qa/refresh fx/checkpoint {:type :task
                                            :task fx/other-goal})]
      (is (= (-> checkpoint :task) fx/other-goal))
      (is (= (-> checkpoint :checkpoint-slug) (str/slugify fx/other-goal)))))

  (testing "query contains url"
    (let [checkpoint (qa/refresh fx/checkpoint {:type :url
                                        :url fx/other-url})]
      (is (= (-> checkpoint :url) fx/other-url)))))

