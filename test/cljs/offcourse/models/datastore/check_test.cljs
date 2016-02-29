(ns offcourse.models.datastore.check-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.datastore.helpers :as h]
            [offcourse.models.datastore.index :as sut]
            [offcourse.protocols.queryable :as qa]))

(deftest models-datastore-check

  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id 1
                         :resource-id id}
        course          {:course-id id
                         :curator   user-id
                         :hashtag   buzzword
                         :checkpoints [checkpoint]}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/check (sut/new) :bla)
             {:type :error :error :query-not-supported})))

    (testing "it returns an falsey value by default"
      (let [types     [:course :resources :collection :collection-names]
            responses (map #(qa/check (sut/new) {:type %}) types)]
        (is (every? #(h/falsy? %) responses))))


    (testing "when query type is collection-names"

      (testing "it reports if collection-names are present"
        (let [store (sut/new {:collection-names {:flag [id]}})]
          (is (qa/check store :collection-names nil))))

      (testing "it reports if collection-names are missing"
        (let [store (sut/new)]
          (is (not (qa/check store :collection-names nil))))))


    (testing "when query type is collection"
      (let [collections [(assoc collection :course-ids #{123}) (assoc collection :collection-name :nettiquette)]
            store       (sut/new {:collections collections})]

        (testing "it reports if a collection is present"
          (let [check (fn [type name] (qa/check store :collection (h/collection type name)))]
            (are [type name expectation] (= (check type name) expectation)
              collection-type buzzword        true
              collection-type :netiquette     false
              collection-type :bla            false
              :bla            buzzword        false
              :bla            :bla            false)))))

    (testing "when query type is courses"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if courses are present"
          (let [check (fn [course-ids] (qa/check store :courses course-ids))]
            (are [course-ids expectation] (= (check course-ids) expectation)
              [id]         true
              [missing-id] false)))))

    (testing "when query type is course"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if course is present by checking its id"
          (let [check (fn [course-id] (qa/check store :course (h/course course-id)))]
            (are [course-id expectation] (= (check course-id) expectation)
              id         true
              missing-id false)))

        (testing "it reports if course is present by checking its curator and hashtag"
          (let [check (fn [curator hashtag] (qa/check store :course (h/course curator hashtag)))]
            (are [curator hashtag expectation] (= (check curator hashtag) expectation)
              user-id buzzword true
              user-id :bla     false
              :bla    buzzword false
              :bla    :bla     false)))))

    (testing "when query type is checkpoint"
      (let [new-checkpoint {:checkpoint-id :new}
            course (update course :checkpoints #(conj % new-checkpoint))
            store (sut/new {:courses [course]})]

        (testing "it reports if course is present by checking its id"
          (let [check (fn [course-id checkpoint-id] (qa/check store :checkpoint
                                                              (h/checkpoint course-id checkpoint-id)))]
            (are [course-id checkpoint-id expectation]
                (= (check course-id checkpoint-id) expectation)
              id         :new     true
              id         1        true
              missing-id :new     false
              missing-id 1        false)))))

    (testing "when query type is resources"
      (let [store (sut/new {:resources {123 {:resource-id 123}}})]

        (testing "it reports if resources are present"
          (let [check (fn [resource-ids] (qa/check store :resources resource-ids))]
            (are [resource-ids expectation] (= (check resource-ids) expectation)
              [id]         true
              [missing-id] false)))))

    (testing "when query type is resource"
      (let [store (sut/new {:resources {123 {:resource-id 123}}})]

        (testing "it reports if resource is present"
          (let [check (fn [resource-id] (qa/check store :resource (h/resource resource-id)))]
            (are [resource-id expectation] (= (check resource-id) expectation)
              id         true
              missing-id false)))))))
