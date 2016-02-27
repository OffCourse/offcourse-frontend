(ns offcourse.models.datastore.missing-data
  (:require [offcourse.protocols.validatable :as va]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [offcourse.models.appstate :as as]))

(deftest models-datastore-missing-data

  #_(let [course {:course-id 123}
        store (sut/new {:appstate (as/new :course-view :course course)})]

    (testing "it is false when data-deps are not in datastore"
      (is (= (va/valid? store) false)))

    (testing "it is true when data-deps are in datastore"
      (is (= (va/valid? (assoc store {:courses  [course]}) true))))))
