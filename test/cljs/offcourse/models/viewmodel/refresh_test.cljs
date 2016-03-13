(ns offcourse.models.viewmodel.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.viewmodel.index :as sut]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.viewmodel.index :as vm]
            [offcourse.models.course.index :as co]
            [cuerdas.core :as str]))

(deftest models-viewmodel-refresh
  (let [id              123
        missing-id      223
        user-id         :yeehaa
        goal            "alone in the dark"
        slug            (str/slugify goal)
        buzzword        :agile
        url             "http://offcourse.io"
        new-url1        "http://bla.com"
        new-url2        "http://blabla.com"
        missing-url     "http://facebook.co"
        course          (co/new {:course-id id
                                 :curator   user-id
                                 :goal goal
                                 :slug slug})
        collection-type :flags
        checkpoint      {:url url
                         :checkpoint-slug slug}
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
                                                     :checkpoint checkpoint})
             (vm/new {:type :checkpoint-view
               :dependencies {:course course
                              :checkpoint checkpoint}}))))

  (testing "when query type is course-view"

    (is (= (qa/refresh (sut/new) :course-view)
           {:type :error :error :query-not-supported}))

    (is (= (qa/refresh (sut/new) :course-view {:course course})
           (vm/new {:type :course-view
                    :dependencies {:course course}}))))

  (testing "when query type is non-existing"
    (is (= (qa/refresh (sut/new) :bla)
           {:type :error :error :query-not-supported})))))
