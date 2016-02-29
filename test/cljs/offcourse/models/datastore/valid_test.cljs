(ns offcourse.models.datastore.valid-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.datastore.index :as sut]
            [offcourse.protocols.validatable :as va]))

(deftest models-datastore-valid?
  (let [course {:course-id 123}
        store (sut/new)]

    (testing "it is true when store is empty"
      (is (= (va/valid? store) true)))))

