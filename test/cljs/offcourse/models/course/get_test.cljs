(ns offcourse.models.course.get-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [cuerdas.core :as str]
            [offcourse.models.course.index :as sut]
            [offcourse.protocols.queryable :as qa]))

(deftest models-course-get
  (let [id              123
        missing-id      223
        goal            "alone in the dark"
        slug            (str/slugify goal)
        url             "http://offcourse.io"
        missing-url     "http://gibbon.co"
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id 1
                         :checkpoint-slug slug
                         :tags [buzzword]
                         :url url}]

    (testing "query type is not supported"
      (is (= (qa/get (sut/new) :bla {}) {:type :error :error :query-not-supported})))

    (testing "query type is tags"
      (let [sut (sut/new)]
        (is (= (qa/get (sut/new) :tags {}) #{})))

      (let [sut (assoc (sut/new) :checkpoints [checkpoint])]
        (is (= (qa/get sut :tags {}) #{:agile}))))

    (testing "query type is checkpoint"
      (let [sut (assoc (sut/new) :checkpoints [{:checkpoint-slug "hello-world"}
                                               checkpoint])]
        (is (= (qa/get sut :checkpoint {:checkpoint-slug slug}) checkpoint))))

    (testing "query type is checkpoint"
      (let [sut (assoc (sut/new) :checkpoints [{:checkpoint-id 0}
                                               checkpoint])]
        (is (= (qa/get sut :checkpoint {:checkpoint-id 1}) checkpoint))))

    (testing "query type is urls"
      (let [sut (assoc (sut/new) :checkpoints [checkpoint])]
        (is (= (qa/get sut :urls {}) #{url}))))))
