(ns offcourse.models.appstate-test
(:require [offcourse.protocols.validatable :as va]
          [offcourse.models.appstate :as sut]
          [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-appstate-check
  (testing "it returns false with an invalid appstate"
    (is (= (va/valid? (sut/new :course-view [])) false)))

  (testing "it returns true with a valid appstate"
    (is (= (va/valid? (sut/new :course-view :course course)) true))))

