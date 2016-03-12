(ns offcourse.models.appstate.missing-data-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.validatable :as va]
            [offcourse.models.course.index :as co]))

(deftest missing-data-test
  (let [course-id            "123"
        url                  "http://offcourse.io"
        course               (co/new {:course-id   course-id
                                      :checkpoints [{:url url}]})
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

      (is (= (va/missing-data (sut/new {:viewmodel {:type :loading-view}}))
             nil))
      (is (= (va/missing-data (sut/new {:viewmodel {:type :bla-view}}))
             {:type :error :error :appstate-empty})))

    (testing "missing course"
      (is (= (va/missing-data (sut/new {:viewmodel {:type         :checkpoint-view
                                                    :dependencies checkpoint-view-data} }))
             {:type   :course
              :course course})))

    (testing "missing resources in course"
      (is (= (va/missing-data (sut/new {:viewmodel {:type         :checkpoint-view
                                                    :dependencies checkpoint-view-data}
                                        :courses   [course]}))
             { :type :resources
              :urls #{url} })))

    (testing "missing resources in new-course"
      (is (= (va/missing-data (sut/new {:viewmodel {:type         :course-view
                                                    :dependencies new-course-view-data}
                                        :courses   [course]}))
             {:type :resources
              :tags [:featured]})))

    (testing "missing courses in collection"
      (is (= (va/missing-data (sut/new {:viewmodel   {:type         :collection-view
                                                      :dependencies collection-view-data}
                                        :collections [collection]} ))
             {:type       :courses
              :course-ids #{course-id}})))

    (testing "happy path"
      (is (= (va/missing-data (sut/new {:viewmodel   {:type          :collection-view
                                                      :dependencies collection-view-data}
                                        :collections [collection]
                                        :courses     [course]})) nil))


      (is (= (va/missing-data (sut/new {:viewmodel {:type :checkpoint-view
                                                    :view-data checkpoint-view-data}
                                        :courses   [course]
                                        :resources [{:url url}]})) nil)))))
