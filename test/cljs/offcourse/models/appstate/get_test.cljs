(ns offcourse.models.appstate.get-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.appstate.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-appstate-get

  (testing "it returns an error if given an non-exisiting query type"
    (is (= (qa/get (sut/new) :bla {}) {:type :error :error :query-not-supported})))

  (testing "it returns nil by default"
    (let [types     [:course :courses :resources :collection]
          responses (map #(qa/get (sut/new) % nil) types)]
      (is (every? #(nil? %) responses))))

  (testing "when query type is collection"
    (let [collection (assoc fx/collection :course-ids #{123})
          store      (sut/new {:collections [collection]})
          get        (partial qa/get store :collection)]

      (testing "it retrieves a collection"
        (are [type name expectation] (= (get (h/collection type name)) expectation)
          fx/collection-type       fx/buzzword       collection
          fx/collection-type       fx/other-buzzword nil
          fx/collection-type       fx/other-buzzword nil
          fx/other-collection-type fx/buzzword       nil
          fx/other-collection-type fx/other-buzzword nil))))

  (testing "when query type is courses"
    (let [store (sut/new {:courses [fx/course]})
          get   (partial qa/get store :courses)]

      (testing "it retrieves the courses"
        (are [course-ids expectation] (= (get course-ids) expectation)
          [fx/course]                  [fx/course]
          [{:course-id fx/missing-id}] nil))))

  (testing "when query type is course"
    (let [store (sut/new {:courses [fx/course]})
          get   (partial qa/get store :course)]

      (testing "it retrieves a course by id"
        (are [course-id expectation] (= (get (h/course-by-id course-id)) expectation)
          fx/id         fx/course
          fx/missing-id nil))

      (testing "it retrieves a course by curator and goal"
        (are [curator goal expectation] (= (get (h/course-by-goal curator goal)) expectation)
          fx/user-name       fx/goal       fx/course
          fx/user-name       fx/other-goal nil
          fx/other-user-name fx/goal       nil
          fx/other-user-name fx/other-goal nil))

      (testing "it retrieves a course by curator and slug"
        (are [curator slug expectation] (= (get (h/course-by-slug curator slug)) expectation)
          fx/user-name       fx/slug       fx/course
          fx/user-name       fx/other-slug nil
          fx/other-user-name fx/slug       nil
          fx/other-user-name fx/other-slug nil))))

  (testing "when query type is checkpoint"
    (let [store (sut/new {:courses [fx/course]})
          get   (partial qa/get store :checkpoint)]

      (testing "it retrieves a checkpoint by slug"
        (are [course-id checkpoint-slug expectation]
            (= (get (h/checkpoint-by-slug course-id checkpoint-slug)) expectation)
          fx/id         fx/slug fx/checkpoint
          fx/missing-id fx/slug nil))

      (testing "it retrieves a checkpoint by id"
        (are [course-id checkpoint-id expectation]
            (= (get (h/checkpoint course-id checkpoint-id)) expectation)
          fx/id         1 fx/checkpoint
          fx/missing-id 1 nil))))

  (testing "when query type is resources"
    (let [store (sut/new {:resources [fx/resource]})
          get   (partial qa/get store :resources)]

      (testing "it retrieves the resources"
        (are [resource-ids expectation] (= (get resource-ids) expectation)
          [fx/resource]           [fx/resource]
          [{:url fx/missing-url}] nil))))

  (testing"when query type is resource"
    (let [store (sut/new {:resources [fx/resource]})
          get   (partial qa/get store :resource)]

      (testing "it retrieves a resource"
        (are [url expectation] (= (get (h/resource url)) expectation)
          fx/url         fx/resource
          fx/missing-url nil)))))
