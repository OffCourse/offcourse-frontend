(ns offcourse.models.datastore.valid-test
  (:require [offcourse.protocols.validatable :as va]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [offcourse.models.appstate :as as]))

(deftest models-datastore-check
  (testing "without a query"
    (let [course {:course-id 123}]

      (testing "it is false when data-deps are not in datastore"
        (is (= (va/valid? (sut/new {:appstate (as/new :course-view :course course)}))
               false)))

      (testing "it is true when data-deps are in datastore"
        (is (= (va/valid? (sut/new {:courses  [course]
                                    :appstate (as/new :course-view :course course)}))
               true))))))
