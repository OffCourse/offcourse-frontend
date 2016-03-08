(ns offcourse.models.appstate.missing-data-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.validatable :as va]))

(deftest missing-data-test
  (let [course-id            "123"
        url                  "http://offcourse.io"
        course               {:course-id   course-id
                              :checkpoints [{:url url}]}
        collection           {:collection-type :flags
                              :collection-name :agile
                              :course-ids      #{course-id}}
        new-course-view-data {:type   :course
                              :course (assoc course :course-id :new)}
        checkpoint-view-data {:type   :course
                              :course course}
        collection-view-data {:type       :collection
                              :collection (dissoc collection :course-ids)}]
    (testing "empty store"
      (is (= (va/missing-data (sut/new {:view-type :loading-view}))
             nil))
      (is (= (va/missing-data (sut/new {:view-type :bla-view}))
             {:type :error :error :appstate-empty})))

    (testing "missing course"
      (is (= (va/missing-data (sut/new {:view-type :checkpoint-view
                                        :view-data checkpoint-view-data}))
             {:type   :course
              :course course})))

    (testing "missing resources in course"
      (is (= (va/missing-data (sut/new {:view-type :checkpoint-view
                                        :view-data checkpoint-view-data
                                        :courses   [course]}))
             {:type :resources
              :urls [url]})))

    (testing "missing resources in new-course"
      (is (= (va/missing-data (sut/new {:view-type :new-course-view
                                        :view-data new-course-view-data
                                        :courses   [course]}))
             {:type :resources
              :tags [:featured]})))

    (testing "missing courses in collection"
      (is (= (va/missing-data (sut/new {:view-type   :collection-view
                                        :view-data   collection-view-data
                                        :collections [collection]}))
             {:type       :courses
              :course-ids #{course-id}})))

    (testing "happy path"
      (is (= (va/missing-data (sut/new {:view-type   :collection-view
                                        :view-data   collection-view-data
                                        :collections [collection]
                                        :courses     [course]})) nil))


      (is (= (va/missing-data (sut/new {:view-type :checkpoint-view
                                        :view-data checkpoint-view-data
                                        :courses   [course]
                                        :resources [{:url url}]})) nil)))))
