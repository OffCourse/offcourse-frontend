(ns offcourse.models.appstate.add-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.checkpoint :as  cp]
            [offcourse.models.appstate.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-appstate-add

  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id 1
                         :resource-id   id}
        course          {:course-id   id
                         :curator     user-id
                         :hashtag     buzzword
                         :checkpoints [checkpoint]}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/add (sut/new) :bla {})
             {:type :error :error :query-not-supported})))))
