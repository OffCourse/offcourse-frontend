(ns offcourse.models.viewmodel.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.viewmodel.index :as sut]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.viewmodel.index :as vm]))

(deftest models-viewmodel-refresh
  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        url             "http://offcourse.io"
        new-url1        "http://bla.com"
        new-url2        "http://blabla.com"
        missing-url     "http://facebook.co"
        course          {:course-id id
                         :curator   user-id
                         :hashtag   buzzword}
        collection-type :flags
        checkpoint      {:url url}
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}
        resource        {:url url}]

    (testing "when query type is collection-view"

    (is (= (qa/refresh (sut/new) :collection-view)
           {:type :error :error :query-not-supported}))

    (is (= (qa/refresh (sut/new) :collection-view {:collection collection})
           (vm/new {:type :collection-view
                    :dependencies {:collection collection}}))))

  (testing "when query type is checkpoint-view"

      (is (= (qa/refresh (sut/new) :checkpoint-view)
             {:type :error :error :query-not-supported}))

      (is (= (qa/refresh (sut/new) :checkpoint-view {:course course
                                                     :checkpoint-id id})
             (vm/new {:type :checkpoint-view
               :dependencies {:course course
                              :checkpoint-id id}}))))

  (testing "when query type is course-view"

    (is (= (qa/refresh (sut/new) :course-view)
           {:type :error :error :query-not-supported}))

    (is (= (qa/refresh (sut/new) :course-view {:course course})
           (vm/new {:type :course-view
             :dependencies {:course course}})))

    (is (= (qa/refresh (sut/new {:dependencies {:course course}})
                                :course-view {:checkpoint checkpoint})
           (let [course (update course :checkpoints #(conj % checkpoint))]
             (vm/new {:type :course-view
               :dependencies {:course course}})))))

  (testing "when query type is non-existing"
    (is (= (qa/refresh (sut/new) :bla)
           {:type :error :error :query-not-supported})))))
