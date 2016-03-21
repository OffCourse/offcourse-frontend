(ns offcourse.models.appstate.check-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.queryable :as qa]
            [cuerdas.core :as str]))

(deftest models-appstate-check
  (testing "it returns an error if given an non-exisiting query type"
    (is (= (qa/check (sut/new) :bla)
           {:type :error :error :query-not-supported})))

  (testing "it returns an falsey value by default"
    (let [types     [:course :resources :collection]
          responses (map #(qa/check (sut/new) {:type %}) types)]
      (is (every? #(h/falsy? %) responses))))

  (testing "when query type is collection"
    (let [collections [(assoc fx/collection :course-ids #{fx/id})
                       (assoc fx/collection :collection-name fx/other-buzzword)]
          store       (sut/new {:collections collections})]

      (testing "it reports if a collection is present"
        (let [check (fn [type name] (qa/check store :collection (h/collection type name)))]
          (are [type name expectation] (= (check type name) expectation)
            fx/collection-type       fx/buzzword             true
            fx/collection-type       fx/other-buzzword       true
            fx/collection-type       fx/yet-another-buzzword false
            fx/other-collection-type fx/buzzword             false
            fx/other-collection-type fx/other-buzzword       false)))))

  (testing "when query type is courses"
    (let [store (sut/new {:courses [fx/course]})]

      (testing "it reports if courses are present"
        (let [check (fn [courses] (qa/check store :courses courses))]
          (are [courses expectation] (= (check courses) expectation)
            [fx/course]                  true
            [{:course-id fx/missing-id}] false)))))

  (testing "when query type is course"
    (let [store (sut/new {:user    {:name fx/user-name}
                          :courses [fx/course]})]

      (testing "it reports if course is present by checking its id"
        (let [check (fn [course-id] (qa/check store :course (h/course-by-id course-id)))]
          (are [course-id expectation] (= (check course-id) expectation)
            fx/id         true
            fx/missing-id false)))))

  (testing "when query type is checkpoint"
    (let [store          (sut/new {:courses [fx/course]})]

      (testing "it reports if checkpoint is present by checking its id"
        (let [check (fn [course-id checkpoint-id]
                      (qa/check store :checkpoint
                                (h/checkpoint course-id checkpoint-id)))]
          (are [course-id checkpoint-id expectation]
              (= (check course-id checkpoint-id) expectation)
            fx/id         1    true
            fx/missing-id 1    false)))))

  (testing "when query type is resources"
    (let [store (sut/new {:resources [fx/resource]})]

      (testing "it reports if resources are present"
        (let [check (fn [resources] (qa/check store :resources resources))]
          (are [resources expectation] (= (check resources) expectation)
            []                   true
            [fx/resource]           true
            [{:url fx/missing-url}] false)))))

  (testing "when query type is resource"
    (let [store (sut/new {:resources [fx/resource]})]

      (testing "it reports if resource is present"
        (let [check (fn [url] (qa/check store :resource (h/resource url)))]
          (are [url expectation] (= (check url) expectation)
            fx/url         true
            fx/missing-url false))))))
