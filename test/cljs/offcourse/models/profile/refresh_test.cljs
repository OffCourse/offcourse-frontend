(ns offcourse.models.profile.refresh-test
  (:require [cljs.test :refer-macros [deftest is testing]]
            [offcourse.models.fixtures :as fx]
            [offcourse.protocols.queryable :as qa]))

(deftest models-profile-refresh
  (testing "query contains user-name"
    (let [profile (qa/refresh fx/profile {:type :user-name
                                          :user-name (str fx/other-user-name)})]
      (is (= (-> profile :user-name) fx/other-user-name)))))
