(ns offcourse.models.viewmodel.convertible-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.viewmodel.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.system.routes :as routes]
            [offcourse.protocols.convertible :as cv]))

(deftest models-viewmodel-convertible

  (testing "new course view"
    (is (= (cv/to-url fx/new-course-vm routes/table) (str "/" (name fx/user-name) "/new"))))

  (testing "checkpoint view"
    (is (= (cv/to-url fx/checkpoint-vm routes/table) (str "/" (name fx/user-name) "/courses/" fx/slug
                                                          "/checkpoints/" fx/slug))))

  (testing "collection view"
    (is (= (cv/to-url fx/collection-vm routes/table) (str "/" (name fx/collection-type)
                                                          "/" (name fx/buzzword))))))
