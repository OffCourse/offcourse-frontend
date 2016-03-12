(ns offcourse.models.course.add-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.course.index :as sut]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

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
                         :tags [buzzword]
                         :url url}]

    (testing "query type is not supported"
      (is (= (qa/get (sut/new) :bla {}) {:type :error :error :query-not-supported})))

    (testing "query type is checkpoint"

      (let [sut (-> (sut/new)
               (assoc :checkpoints [{:checkpoint-id 0}])
               (qa/add :checkpoint checkpoint))]

        (is (= (count (:checkpoints sut)) 2))))))



