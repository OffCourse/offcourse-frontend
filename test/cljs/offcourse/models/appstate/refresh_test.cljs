(ns offcourse.models.appstate.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.datastore.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.datastore.index :as ds :refer [Datastore]]
            [offcourse.models.datastore.paths :as paths]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(deftest models-appstate-refresh
  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        course          {:course-id id
                         :curator   user-id
                         :hashtag   buzzword}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}]

    (testing "when query type is non-existing"
      (is (= (qa/refresh (sut/new) :bla)
             {:type :error :error :query-not-supported})))

    (testing "when query type is appstate"

        (let [query {:type :appstate
                     :appstate {:view-type :course-view
                                :data-deps {:course course}}}
              store (ds/new)
              state (qa/refresh (sut/new) query)]
          (is (= :course-view (:view-type state)))
          (is (= store (:store state)))))

    #_(testing "when query type belongs to datastore"

        (let [query {:type :course
                     :course course}
              store (ds/new)
              state (qa/refresh (sut/new) query)]
          (println store)
          (println (select-first (paths/course id) (:store state)))))))
