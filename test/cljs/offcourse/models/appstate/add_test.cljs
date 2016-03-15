(ns offcourse.models.appstate.add-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.checkpoint :as  cp]
            [offcourse.models.appstate.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]
            [offcourse.models.course.index :as co]))

(deftest models-appstate-add

  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        url             "http://offcourse.io"
        goal            "alone in the dark"
        slug            (str/slugify goal)
        checkpoint      {:checkpoint-id 1
                         :resource-id   id}
        course          (co/map->Course {:course-id   id
                                         :course-slug slug
                                         :curator     user-id
                                         :hashtag     buzzword
                                         :checkpoints [checkpoint]})
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}
        resource        {:url url}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/add (sut/new) :bla {})
             {:type :error :error :query-not-supported})))

    (testing "when query type is courses"

      (testing "it adds new courses"
        (let [store (-> (sut/new)
                        (qa/add :courses [course]))]
          (is (= (:courses store) [course])))))

    (testing "when query type is course"

      (testing "it adds a new course"
        (let [store (-> (sut/new)
                        (qa/add :course course))]
          (is (= (first (:courses store)) course)))))

    (testing "when query type is resources"

      (testing "it adds new resources"
        (let [store (-> (sut/new)
                        (qa/add :resources [resource]))]
          (is (= (:resources store) [resource])))))

    (testing "when query type is resource"

      (testing "it adds a new resource"
        (let [store (-> (sut/new)
                        (qa/add :resource resource))]
          (is (= (first (:resources store)) resource)))))))
