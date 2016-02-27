(ns offcourse.models.datastore.valid-test
  (:require [offcourse.protocols.validatable :as va]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [offcourse.models.appstate :as as]))

(deftest models-datastore-check
  (let [course {:course-id 123}
        store (sut/new)]

    (testing "it is false when store is empty"
      (is (= (va/valid? store) false)))))

