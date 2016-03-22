(ns offcourse.models.appstate.missing-data-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.validatable :as va]))

(deftest missing-data-test

  (testing "store"

    (testing "empty store"
      (is (= (va/missing-data (sut/new {:viewmodel {:type :loading-view}}))
             nil)))

    (testing "missing course"
      (let [store        (sut/new)
            missing-data (va/missing-data store {:type :course
                                                 :course fx/course})]
        (is (= missing-data {:type :course
                             :course {:course-id fx/id}}))))

    (testing "missing courses"
      (let [store        (sut/new {:courses [fx/course]})
            missing-data (va/missing-data store {:type :courses
                                                 :courses [fx/course {:course-id "234"}]})]
        (is (= missing-data {:type :courses
                             :courses [{:course-id "234"}]}))))

    (testing "missing resource"
      (let [store        (sut/new)
            missing-data (va/missing-data store {:type :resource
                                                 :resource fx/resource})]
        (is (= missing-data {:type :resource
                             :resource {:url fx/url}}))))

    (testing "missing resources"
      (let [store        (sut/new {:resources [fx/resource]})
            missing-data (va/missing-data store {:type :resources
                                                 :resources [fx/resource {:url fx/missing-url}]})]
        (is (= missing-data {:type :resources
                             :resources [{:url fx/missing-url}]}))))

    (testing "happy path"
      (is (= (va/missing-data (sut/new {:courses [fx/course]})
                              {:course fx/course}) nil))))


  (testing "loading-view"
    (testing "empty store"
      (is (= (va/missing-data (sut/new fx/loading-vm)) nil))))

  (testing "checkpoint-view"
    (let [store (sut/new {:viewmodel fx/checkpoint-vm})]

      (testing "missing course"
        (is (= (-> store va/missing-data :course :course-id) fx/id)))

      (testing "missing resources "
        (let [store (assoc store :courses [fx/course])]
          (is (= (va/missing-data store) {:type :resources
                                          :urls  #{fx/url} }))))

      (testing "happy path"
        (let [store (assoc store :courses [fx/course]
                           :resources [fx/resource])]
          (is (= (va/missing-data store) nil))))))

  (testing "course-view"
    (testing "missing resources in course-view"
      (is (= (va/missing-data (sut/new {:viewmodel fx/new-course-vm
                                        :courses   [fx/course]}))
             {:type :resources
              :tags [:featured]}))))

  (testing "collection-view"
    (let [collection (assoc fx/collection :course-ids #{fx/id})
          store (sut/new {:viewmodel fx/collection-vm
                          :collections [collection]})]

    (testing "missing courses in collection-view"
      (is (= (va/missing-data store)
             {:type       :courses
              :course-ids #{fx/id}})))

    (testing "happy path"
      (is (= (va/missing-data (assoc store :courses [fx/course])) nil))))))
