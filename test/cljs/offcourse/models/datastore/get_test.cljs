(ns offcourse.models.datastore.get-test
  (:require [offcourse.models.datastore.get :as ds]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-datastore-get
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
                         :course-ids      #{id}}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (ds/get (sut/new) (h/query :bla))
             {:type :error :error :query-not-supported})))

    (testing "it returns nil by default"
      (let [types     [:course :courses :resources :collection]
            responses (map #(ds/get (sut/new) {:type %}) types)]
        (is (every? #(nil? %) responses))))


    (testing "when query type is collection"
      (let [collections {:agile      (assoc collection :course-ids #{123})}
            store       (sut/new {:collections {collection-type collections}})]

        (testing "it reports if a collection is present"
          (letfn [(query [type name] (h/query :collection
                                              :collection-type type
                                              :collection-name name))
                  (get [type name] (ds/get store (query type name)))]
            (are [type name expectation] (= (get type name) expectation)
              collection-type buzzword        collection
              collection-type :netiquette     nil
              collection-type :bla            nil
              :bla            buzzword        nil
              :bla            :bla            nil)))))


    (testing "when query type is courses"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if courses are present"
          (letfn [(query [course-ids] (h/query :courses
                                               :course-ids course-ids))
                  (get [course-ids] (ds/get  store (query course-ids)))]
            (are [course-ids expectation] (= (get course-ids) expectation)
              [id]         [course]
              [missing-id] nil)))))


    (testing "when query type is course"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if course is present by checking its id"
          (letfn [(query [course-id] (h/query :course
                                              :course-id course-id))
                  (get [course-id] (ds/get store (query course-id)))]
            (are [course-id expectation] (= (get course-id) expectation)
              id         course
              missing-id nil)))

        (testing "it reports if course is present by checking its curator and hashtag"
          (letfn [(query [curator hashtag] (h/query :course
                                                    :curator curator
                                                    :hashtag hashtag))
                  (get [curator hashtag] (ds/get store (query curator hashtag)))]
            (are [curator hashtag expectation] (= (get curator hashtag) expectation)
              user-id buzzword course
              user-id :bla     nil
              :bla    buzzword nil
              :bla    :bla     nil)))))

))
