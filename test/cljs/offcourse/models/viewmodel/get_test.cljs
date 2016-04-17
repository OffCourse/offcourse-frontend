(ns offcourse.models.viewmodel.get-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.viewmodel.index :as sut]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]
            [offcourse.models.profile.index :as pf]))

(deftest models-viewmodel-get
  (let [viewmodel (sut/new {:type :new-user-view})]

    (testing "query type is not supported"
      (is (= (qa/get viewmodel :bla {}) {:type :error :error :query-not-supported})))

    (testing "query type is profile"
      (is (= (qa/get viewmodel :profile {}) (pf/new {})))
      (is (= (qa/get (assoc-in viewmodel [:dependencies :profile] fx/user) :profile {}) fx/user)))

    (testing "query type is course"
      (is (= (qa/get viewmodel :course {}) nil))
      (is (= (qa/get (assoc-in viewmodel [:dependencies :course] fx/course) :course {}) fx/course)))))

