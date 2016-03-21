(ns offcourse.models.appstate.add-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.checkpoint :as  cp]
            [offcourse.models.fixtures :as  fx]
            [offcourse.models.appstate.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]
            [offcourse.models.collection :as cl]
            [offcourse.models.course.index :as co]))

(deftest models-appstate-add

  (testing "it returns an error if given an non-exisiting query type"
    (is (= (qa/add (sut/new) :bla {})
           {:type :error :error :query-not-supported})))

  (testing "when query type is collection"
    (let [store (qa/add (sut/new) :collection fx/collection)]

    (testing "it adds new collection"
        (is (= (:collections store) [fx/collection])))))

  (testing "when query type is courses"
    (let [store (qa/add (sut/new) :courses [fx/course])]

      (testing "it adds new courses"
        (is (= (:courses store) [fx/course])))))

  (testing "when query type is course"

    (testing "without a user"
      (let [course        (assoc fx/course :curator nil)
            store         (qa/add (sut/new) :course course)]

        (testing "it does not adds a new course"
          (is (= (:courses store) [])))

        (testing "it does not adds the course-id to the right collections"
          (are [collection] (not (contains? (:course-ids (qa/get store :collection collection)) fx/id))
            fx/flag-collection
            fx/curator-collection
            fx/tag-collection))))

    (testing "with a user"
      (let [store         (-> (sut/new {:user fx/user})
                              (qa/add :course fx/course))]

        (testing "it adds a new course"
          (is (= (:courses store) [fx/course])))

        (testing "it adds the course-id to the right collections"
          (are [collection] (contains? (:course-ids (qa/get store :collection collection)) fx/id)
            fx/flag-collection
            fx/curator-collection
            fx/tag-collection)))))

  (testing "when query type is resources"
    (let [store (qa/add (sut/new) :resources [fx/resource])]
    (testing "it adds new resources"
        (is (= (:resources store) [fx/resource])))))

  (testing "when query type is resource"
    (let [store (qa/add (sut/new) :resource fx/resource)]

    (testing "it adds a new resource"
      (is (= (:resources store) [fx/resource]))))))
