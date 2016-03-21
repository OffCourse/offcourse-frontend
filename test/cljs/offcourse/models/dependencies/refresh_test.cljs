(ns offcourse.models.dependencies.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.dependencies.index :as sut]
            [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.checkpoint :as cp]
            [cuerdas.core :as str]))

(deftest models-dependencies-refresh
  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        title           "hello world"
        url             "http://offcourse.io"
        new-url1        "http://bla.com"
        new-url2        "http://blabla.com"
        missing-url     "http://facebook.co"
        collection-type :flags
        checkpoint      {:task title
                         :checkpoint-slug (str/slugify title)
                         :tags #{buzzword}}
        course          (co/new {:course-id id
                                 :goal title
                                 :flags     #{collection-type}
                                 :checkpoints []
                                 :curator   user-id
                                 :hashtag   buzzword})]

    (testing "when action type is add-checkpoint"
      (let [action {:type :add-checkpoint
                    :checkpoint checkpoint}
            dependencies (qa/refresh (sut/new {:course course}) action)]
        (is (= (-> dependencies :course :checkpoints count) 1))))

    (testing "when action type is delete-checkpoint"
      (let [action {:type :delete-checkpoint
                    :checkpoint checkpoint}
            course (qa/add course checkpoint)
            dependencies (qa/refresh (sut/new {:course course}) action)]
        (is (= (-> dependencies :course :checkpoints count) 0))))

    (testing "when action type is update-goal"
      (let [new-title "goodbye world"
            action {:type :update-goal
                    :goal new-title}
            dependencies (qa/refresh (sut/new {:course course}) action)]
        (is (= (-> dependencies :course :goal) new-title))
        (is (= (-> dependencies :course :course-slug) (str/slugify new-title)))))

    (testing "when action type is update-curator"

      (let [new-curator :greg
            action {:type :update-curator
                    :curator new-curator}
            dependencies (qa/refresh (sut/new) action)]
        (is (= dependencies (sut/new))))

      (let [new-curator nil
            action {:type :update-curator
                    :curator new-curator}
            dependencies (qa/refresh (sut/new {:course course}) action)]
        (is (= dependencies (sut/new {:course course}))))

      (let [new-curator :greg
            action {:type :update-curator
                    :curator new-curator}
            dependencies (qa/refresh (sut/new {:course course}) action)]
        (is (= (-> dependencies :course :curator) user-id))))))
