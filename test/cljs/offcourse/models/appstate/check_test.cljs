(ns offcourse.models.appstate.check-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.protocols.queryable :as qa]
            [cuerdas.core :as str]))

(deftest models-appstate-check

  (let [id              123
        missing-id      223
        url             "http://offcourse.io"
        goal            "blabla"
        slug            (str/slugify goal)
        missing-url     "http://gibbon.co"
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id 1
                         :resource-id   id}
        course          {:course-id   id
                         :goal        goal
                         :slug        slug
                         :curator     user-id
                         :hashtag     buzzword
                         :checkpoints [checkpoint]}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}
        resource        {:url url}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/check (sut/new) :bla)
             {:type :error :error :query-not-supported})))

    (testing "it returns an falsey value by default"
      (let [types     [:course :resources :collection]
            responses (map #(qa/check (sut/new) {:type %}) types)]
        (is (every? #(h/falsy? %) responses))))


    (testing "when query type is collection"
      (let [collections [(assoc collection :course-ids #{123}) (assoc collection :collection-name :nettiquette)]
            store       (sut/new {:collections collections})]

        (testing "it reports if a collection is present"
          (let [check (fn [type name] (qa/check store :collection (h/collection type name)))]
            (are [type name expectation] (= (check type name) expectation)
              collection-type buzzword    true
              collection-type :netiquette false
              collection-type :bla        false
              :bla            buzzword    false
              :bla            :bla        false)))))

    (testing "when query type is courses"
      (let [store (sut/new {:courses [course]})]

        (testing "it reports if courses are present"
          (let [check (fn [courses] (qa/check store :courses courses))]
            (are [courses expectation] (= (check courses) expectation)
              [course]                  true
              [{:course-id missing-id}] false)))))

    (testing "when query type is course"
      (let [store (sut/new {:user    {:name user-id}
                            :courses [course]})]

        (testing "it reports if course is present by checking its id"
          (let [check (fn [course-id] (qa/check store :course (h/course-by-id course-id)))]
            (are [course-id expectation] (= (check course-id) expectation)
              id         true
              missing-id false)))

        (testing "it doesn't check if course-id is new"
          (let [check (fn [curator] (qa/check store {:type   :course
                                                     :course {:course-id :new
                                                              :curator   curator}}))]

            (are [curator expectation] (= (check curator) expectation)
              user-id true
              #_:bla  #_false)))

        #_(testing "it reports if course is present by checking curator and hashtag"
            (let [check (fn [curator hashtag] (qa/check store :course (h/course-by-hashtag curator hashtag)))]
            (are [curator hashtag expectation] (= (check curator hashtag) expectation)
              user-id buzzword true
              user-id :bla     false
              :bla    buzzword false
              :bla    :bla     false)))))

    (testing "when query type is checkpoint"
      (let [new-checkpoint {:checkpoint-id :new}
            course         (update course :checkpoints #(conj % new-checkpoint))
            store          (sut/new {:courses [course]})]

        (testing "it reports if course is present by checking its id"
          (let [check (fn [course-id checkpoint-id] (qa/check store :checkpoint
                                                              (h/checkpoint course-id checkpoint-id)))]
            (are [course-id checkpoint-id expectation]
                (= (check course-id checkpoint-id) expectation)
              id         :new true
              id         1    true
              missing-id :new false
              missing-id 1    false)))))

    (testing "when query type is resources"
      (let [store (sut/new {:resources [resource]})]

        (testing "it reports if resources are present"
          (let [check (fn [resources] (qa/check store :resources resources))]
            (are [resources expectation] (= (check resources) expectation)
              []                   true
              [resource]           true
              [{:url missing-url}] false)))))

    (testing "when query type is resource"
      (let [store (sut/new {:resources [resource]})]

        (testing "it reports if resource is present"
          (let [check (fn [url] (qa/check store :resource (h/resource url)))]
            (are [url expectation] (= (check url) expectation)
              url         true
              missing-url false)))))))
