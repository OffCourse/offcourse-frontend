(ns offcourse.models.course.refresh-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.course.index :as sut]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-course-refresh
  (testing "query contains goal"
    (let [course (qa/refresh fx/course {:type :goal
                                        :goal fx/other-goal})]
      (is (= (-> course :goal) fx/other-goal))
      (is (= (-> course :course-slug) (str/slugify fx/other-goal)))))

  (testing "query contains curator"
    (let [course (qa/refresh fx/course {:type :curator
                                        :curator fx/other-user-name})]
      (is (= (-> course :curator) :greg)))))
