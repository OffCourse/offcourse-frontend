(ns offcourse.models.datastore.check-test
  (:require [offcourse.models.datastore.check :as ds]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-datastore-check

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

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (ds/check (sut/new) (h/query :bla))
             {:type :error :error :query-not-supported})))

    (testing "it returns an falsey value by default"
      (let [types     [:course :resources :collection :collection-names]
            responses (map #(ds/check (sut/new) {:type %}) types)]
        (is (every? #(h/falsy? %) responses))))


    (testing "when query type is collection-names"

      (testing "it reports if collection-names are present"
        (let [store (sut/new {:has-collection-names? true})
              query (h/query :collection-names)]
          (is (ds/check store query))))

      (testing "it reports if collection-names are missing"
        (let [store (sut/new {:has-collection-names? false})
              query (h/query :collection-names)]
          (is (not (ds/check store query))))))


    (testing "when query type is collection"
      (let [collections {:agile      (assoc collection :course-ids #{123})
                         :netiquette (assoc collection :collection-name :nettiquette)}
            store       (sut/new {:collections {collection-type collections}})]

        (testing "it reports if a collection is present"
          (letfn [(query [type name] (h/query :collection
                                              :collection-type type
                                              :collection-name name))
                  (check [type name] (ds/check store (query type name)))]
            (are [type name expectation] (= (check type name) expectation)
              collection-type buzzword        true
              collection-type :netiquette     false
              collection-type :bla            nil
              :bla            buzzword        nil
              :bla            :bla            nil)))))


    (testing "when query type is courses"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if courses are present"
          (letfn [(query [course-ids] (h/query :courses
                                               :course-ids course-ids))
                  (check [course-ids] (ds/check  store (query course-ids)))]
            (are [course-ids expectation] (= (check course-ids) expectation)
              [id]         true
              [missing-id] false)))))


    (testing "when query type is course"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if course is present by checking its id"
          (letfn [(query [course-id] (h/query :course
                                              :course-id course-id))
                  (check [course-id] (ds/check store (query course-id)))]
            (are [course-id expectation] (= (check course-id) expectation)
              id         true
              missing-id false)))

        (testing "it reports if course is present by checking its curator and hashtag"
          (letfn [(query [curator hashtag] (h/query :course
                                                    :curator curator
                                                    :hashtag hashtag))
                  (check [curator hashtag] (ds/check store (query curator hashtag)))]
            (are [curator hashtag expectation] (= (check curator hashtag) expectation)
              user-id buzzword true
              user-id :bla     false
              :bla    buzzword false
              :bla    :bla     false)))))


    (testing "when query type is resources"
      (let [store (sut/new {:resources {123 {:resource-id 123}}})]

        (testing "it reports if resources are present"
          (letfn [(query [resource-ids] (h/query :resources
                                                 :resource-ids resource-ids))
                  (check [resource-ids] (ds/check store (query resource-ids)))]
            (are [resource-ids expectation] (= (check resource-ids) expectation)
              [id]         true
              [missing-id] false)))))


    (testing "when query type is resource"
      (let [store (sut/new {:resources {123 {:resource-id 123}}})]

        (testing "it reports if resource is present"
          (letfn [(query [resource-id] (h/query :resource
                                                :resource-id resource-id))
                  (check [resource-id] (ds/check store (query resource-id)))]
            (are [resource-id expectation] (= (check resource-id) expectation)
              id         true
              missing-id false)))))))
