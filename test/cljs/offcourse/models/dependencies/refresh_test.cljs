(ns offcourse.models.dependencies.refresh-test
  (:require [cljs.test :refer-macros [deftest are is testing]]
            [cuerdas.core :as str]
            [offcourse.models.course.index :as co]
            [offcourse.models.dependencies.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]))

(deftest models-dependencies-refresh
  (testing "when action type is add-checkpoint"
    (let [action       {:type       :add-checkpoint
                        :checkpoint fx/checkpoint}
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (is (= (-> dependencies :course :checkpoints count) 1))))

  (testing "when action type is delete-checkpoint"
    (let [action       {:type       :delete-checkpoint
                        :checkpoint fx/checkpoint}
          course       (qa/add fx/course fx/checkpoint)
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (is (= (-> dependencies :course :checkpoints count) 0))))

  (testing "when action type is update-goal"
    (let [action       {:type :update-goal
                        :goal fx/other-goal}
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (are [field value] (= (-> dependencies :course field) value)
        :goal        fx/other-goal
        :course-slug fx/other-slug)))

  (testing "when action type is update-curator"

    (let [action       {:type    :update-curator
                        :curator fx/other-user-name}
          dependencies (qa/refresh (sut/new) action)]
      (is (= dependencies (sut/new))))

    (let [action       {:type    :update-curator
                        :curator nil}
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (is (= dependencies (sut/new {:course fx/course}))))

    (let [action       {:type    :update-curator
                        :curator fx/other-user-name}
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (is (= (-> dependencies :course :curator) fx/user-name)))))
