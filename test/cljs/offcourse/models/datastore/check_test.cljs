(ns offcourse.models.datastore.check-test
  (:require [offcourse.models.datastore.check :refer [check]]
            [offcourse.models.datastore.fixtures :as fx]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest is are]]))

(deftest returns-true-or-false-with-existing-type
  (let [types [:course :courses :resources :collection :collection-names]
        responses (map #(check fx/store {:type %}) types)]
    (is (every? #(h/true-or-false? %) responses))))

(deftest returns-error-with-non-existing-type
  (is (= (check fx/store (h/query :bla))
         {:type :error :error :query-not-supported})))

(deftest knows-if-collection-names-are-present
  (let [query (partial h/query :collection-names)]
    (is (= (check fx/store (query nil)) false))))

(deftest knows-if-collection-is-present
  (let [query (partial h/query :collection)]
    (are [expectation actual] (= expectation actual)
      (check fx/store (query :collection-name fx/collection-name
                             :collection-type fx/collection-type)) true
      (check fx/store (query :collection-name fx/hashtag
                             :collection-type fx/collection-type)) false
      (check fx/store (query :collection-name :bla
                             :collection-type fx/collection-type)) false
      (check fx/store (query :collection-name :bla
                             :collection-type :bla))               false
      (check fx/store (query :collection-name fx/collection-name
                             :collection-type :bla))               false)))

(deftest knows-if-course-is-present
  (let [query (partial h/query :course)]
    (are [expectation actual] (= expectation actual)
      (check fx/store (query :course-id fx/course-id))                 true
      (check fx/store (query :course-id 124))                          false
      (check fx/store (query :curator fx/curator :hashtag fx/hashtag)) true
      (check fx/store (query :curator fx/curator :hashtag :bla))       false)))

(deftest knows-if-courses-are-present
  (let [query (partial h/query :courses)]
    (are [expectation actual] (= expectation actual)
      (check fx/store (query :course-ids [fx/course-id])) true
      (check fx/store (query :course-ids [444]))          false)))

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
