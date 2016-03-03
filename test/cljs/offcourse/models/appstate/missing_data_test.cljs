(ns offcourse.models.appstate.missing-data-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.validatable :as va]))

(deftest missing-data-test
  (let [course-id            "123"
        course               {:course-id course-id}
        collection           {:collection-type :flags
                              :collection-name :agile
                              :course-ids      #{course-id}}
        course-view-data     {:type   :course
                              :course course}
        collection-view-data {:type       :collection
                              :collection (dissoc collection :course-ids)}]

    (testing "missing course"
      (is (= (va/missing-data (sut/new {:view-data course-view-data}))
             {:type   :course
              :course course})))

    (testing "missing courses in collection"
      (is (= (va/missing-data (sut/new {:view-data   collection-view-data
                                        :collections [collection]}))
             {:type       :courses
              :course-ids #{course-id}})))

    (testing "happy path"
      (is (= (va/missing-data (sut/new)) nil))
      (is (= (va/missing-data (sut/new {:view-data   collection-view-data
                                        :collections [collection]
                                        :courses     [course]})) nil))
      (is (= (va/missing-data (sut/new {:view-data course-view-data
                                        :courses   [course]})) nil)))))
