(ns offcourse.models.datastore.check-test
  (:require [offcourse.models.datastore.check :refer [check]]
            [offcourse.models.datastore.fixtures :as fx]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest is are]]))

(deftest returns-a-falsy-value-by-default
  (let [types [:course :courses :resources :collection :collection-names]
        responses (map #(check fx/store {:type %}) types)]
    (is (every? #(h/falsy? %) responses))))

(deftest returns-error-with-non-existing-type
  (is (= (check fx/store (h/query :bla))
         {:type :error :error :query-not-supported})))

(deftest knows-if-collection-names-are-present
  (let [query (partial h/query :collection-names)]
    (is (= (check fx/store (query nil)) false))))

(deftest knows-if-collection-is-present
  (letfn [(query [collection-type collection-name]
            (h/query :collection
                     :collection-type collection-type
                     :collection-name collection-name))]
    (are [collection-type collection-name actual]
        (= (check fx/store (query collection-type collection-name)) actual)
      :flags :taurus     true
      :flags :netiquette false
      :flags :bla        nil
      :bla   :netiquette nil
      :bla   :bla        nil)))

(deftest knows-if-course-is-present-by-id
  (letfn [(query [course-id]
            (h/query :course
                     :course-id course-id))]
    (are [course-id expectation] (= (check fx/store (query course-id)) expectation)
      123 true
      124 false)))

(deftest knows-if-course-is-present-by-curator-and-hashtag
  (letfn [(query [curator hashtag]
            (h/query :course
                     :curator curator
                     :hashtag hashtag))]
    (are [curator hashtag expectation] (= (check fx/store (query curator hashtag)) expectation)
      :yeehaa :netiquette true
      :yeehaa :bla        false)))

(deftest knows-if-courses-are-present
  (letfn [(query [course-ids] (h/query :courses :course-ids course-ids))]
    (are [course-ids expectation] (= (check fx/store (query course-ids)) expectation)
      [123] true
      [444] false)))

(deftest knows-if-resource-is-present
  (let [query (partial h/query :resource)]
    (are [expectation actual] (= expectation actual)
      (check fx/store (query :resource-id fx/resource-id)) true
      (check fx/store (query :resource-id 345))            false)))

(deftest knows-if-resources-are-present
  (let [query (partial h/query :resources)]
    (are [expectation actual] (= expectation actual)
      (check fx/store (query :resource-ids [fx/resource-id])) true
      (check fx/store (query :resource-ids [223]))            false)))
