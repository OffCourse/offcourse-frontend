(ns offcourse.models.appstate-test
(:require [offcourse.protocols.validatable :as va]
          [offcourse.models.appstate :as sut]
          [offcourse.models.datastore.index :as ds]
          [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-appstate-check
  (let [course {:course-id 123}]

    (testing "it returns false with an invalid appstate"
      (is (= (va/valid? (sut/new :course-view [])) false)))

    (testing "it returns false with a valid appstate and and invalid store"
      (is (= (va/valid? (sut/new :course-view
                                 :course course
                                 :store (ds/new))) false)))))
