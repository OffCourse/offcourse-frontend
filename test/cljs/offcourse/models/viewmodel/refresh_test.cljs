(ns offcourse.models.viewmodel.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.viewmodel.index :as sut]
            [offcourse.protocols.queryable :as qa]))

(deftest models-viewmodel-refresh

    (testing "when query type is non-existing"
      (is (= (qa/refresh (sut/new) :bla)
             {:type :error :error :query-not-supported}))))

