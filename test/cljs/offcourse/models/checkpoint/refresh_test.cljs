(ns offcourse.models.checkpoint.refresh-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [cuerdas.core :as str]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]))

(deftest models-checkpoint-refresh
  (testing "query contains task"
    (let [checkpoint (qa/refresh fx/checkpoint {:type :task
                                            :task fx/other-goal})]
      (is (= (-> checkpoint :task) (str/titleize fx/other-goal)))
      (is (= (-> checkpoint :checkpoint-slug) (str/slugify fx/other-goal)))))

  (testing "query contains url"
    (let [checkpoint (qa/refresh fx/checkpoint {:type :url
                                                :url fx/other-url})]
      (is (= (-> checkpoint :url) fx/other-url)))))

