(ns offcourse.models.course.refresh-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.course.index :as sut]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-course-refresh
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

    (testing "query contains goal"
      (let [new-goal "together in the light"
            course (-> (sut/new {:goal goal})
                       (qa/refresh {:type :goal
                                    :goal new-goal}))]
        (is (= (-> course :goal) new-goal))
        (is (= (-> course :course-slug) (str/slugify new-goal)))))

    (testing "query contains curator"
      (let [course (-> (sut/new {:curator user-id})
                       (qa/refresh {:type :curator
                                    :curator :greg}))]
        (is (= (-> course :curator) :greg))))))
