(ns offcourse.models.dependencies.refresh-test
  (:require [cljs.test :refer-macros [deftest are is testing]]
            [cuerdas.core :as str]
            [offcourse.models.course.index :as co]
            [offcourse.models.dependencies.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.profile.index :as pf]
            [offcourse.models.checkpoint.index :as cp]))

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
        :goal        (str/titleize fx/other-goal)
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
      (is (= (-> dependencies :course :curator) fx/user-name))))

  (testing "when action type is update-task"
    (let [action       {:type :update-task
                        :task  fx/other-goal}
          dependencies (qa/refresh (sut/new {:checkpoint (cp/new {})}) action)]
      (are [field value] (= (-> dependencies :checkpoint field) value)
        :task        (str/titleize fx/other-goal)
        :checkpoint-slug fx/other-slug)))

  (testing "when action type is update-url"
    (let [action       {:type :update-url
                        :url  fx/other-url}
          dependencies (qa/refresh (sut/new {:checkpoint (cp/new {})}) action)]
      (is (= (-> dependencies :checkpoint :url) fx/other-url))))

  (testing "when action type is update-tag"
    (let [action       {:type :update-tag
                        :tag  (name fx/other-buzzword)}
          dependencies (qa/refresh (sut/new {:course fx/course}) action)]
      (is (= (-> dependencies :tag) (name fx/other-buzzword)))))

  (testing "when action type is add-tag"
    (let [action       {:type :add-tag
                        :tag  fx/other-buzzword}
          dependencies (qa/refresh (sut/new {:checkpoint (cp/new {})}) action)]
      (is (contains? (-> dependencies :checkpoint :tags) fx/other-buzzword))))

  (testing "when action type is reset-checkpoint"
    (let [action       {:type :reset-checkpoint}
          dependencies (qa/refresh (sut/new {:checkpoint (cp/new {:task "hii"})}) action)]
      (is (= (-> dependencies :checkpoint) (cp/new {:tags #{}
                                                    :completed? false})))))

  (testing "when action type is reset-tag"
    (let [action       {:type :reset-tag}
          dependencies (qa/refresh (sut/new {:tag "hii"}) action)]
      (is (= (-> dependencies :tag) nil))))

  (testing "when action type is update-user-name"
    (let [action       {:type :update-user-name
                        :user-name (name fx/other-user-name)}
          dependencies (qa/refresh (sut/new {:profile (pf/new {:user-name fx/user-name})}) action)]
      (is (= (-> dependencies :profile :user-name) fx/other-user-name)))))
