(ns offcourse.models.datastore.check-test
  (:require [offcourse.models.datastore.check :refer [check]]
            [cljs.test :refer-macros [deftest is are]]))

(def course-id 123)
(def curator :yeehaa)
(def hashtag :netiquette)

(def store {:courses [{:course-id 123
                       :curator curator
                       :hashtag hashtag}
                      {:course-id 589
                       :curator :marijn
                       :hashtag :agile}]})

(defn query [type & args]
  (let [payload (if (= type :courses)
                  (apply hash-map args)
                  {type (apply hash-map args)})]
    (assoc payload :type type)))

(defn true-or-false? [response]
  (or (true? response) (false? response)))

(deftest returns-true-or-false-with-existing-type
  (let [types [:course :courses :resources :collection :collection-names]
        responses (map #(check store {:type %}) types)]
    (is (every? #(true-or-false? %) responses))))

(deftest returns-error-with-non-existing-type
  (is (= (check store (query :bla))
         {:type  :error :error :query-not-supported})))

(deftest knows-if-course-is-present
  (let [query (partial query :course)]
    (are [expectation actual] (= expectation actual)
      (check store (query :course-id course-id)) true
      (check store (query :course-id 124)) false
      (check store (query :curator curator :hashtag hashtag)) true
      (check store (query :curator curator :hashtag :niquette)) false)))

(deftest knows-if-courses-are-present
  (let [query (partial query :courses)]
    (are [expectation actual] (= expectation actual)
      (check store (query :course-ids [course-id])) true
      (check store (query :course-ids [444])) false)))
