(ns offcourse.models.appstate.get-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.appstate.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]
            [cuerdas.core :as str]))

(deftest models-appstate-get
  (let [id              123
        missing-id      223
        goal            "alone in the dark"
        slug            (str/slugify goal)
        url             "http://offcourse.io"
        missing-url     "http://gibbon.co"
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id   1
                         :checkpoint-slug slug
                         :resource-id     id}
        course          {:course-id   id
                         :goal        goal
                         :course-slug slug
                         :curator     user-id
                         :hashtag     buzzword
                         :checkpoints [checkpoint]}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{id}}
        resource        {:url url}]


    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/get (sut/new) :bla {}) {:type :error :error :query-not-supported})))

    (testing "it returns nil by default"
      (let [types     [:course :courses :resources :collection]
            responses (map #(qa/get (sut/new) % nil) types)]
        (is (every? #(nil? %) responses))))

    (testing "when query type is collection"
      (let [store (sut/new {:collections [(assoc collection :course-ids #{123})]})
            get   (partial qa/get store :collection)]

        (testing "it retrieves a collection"
          (are [type name expectation] (= (get (h/collection type name)) expectation)
            collection-type buzzword    collection
            collection-type :netiquette nil
            collection-type :bla        nil
            :bla            buzzword    nil
            :bla            :bla        nil))))

    (testing "when query type is courses"
      (let [store (sut/new {:courses [course]})
            get   (partial qa/get store :courses)]

        (testing "it retrieves the courses"
          (are [course-ids expectation] (= (get course-ids) expectation)
            [id]         [course]
            [missing-id] nil))))

    (testing "when query type is course"
      (let [store (sut/new {:courses [course]})
            get   (partial qa/get store :course)]

        (testing "it retrieves a course by id"
          (are [course-id expectation] (= (get (h/course-by-id course-id)) expectation)
            id         course
            missing-id nil))

        (testing "it retrieves a course by curator and goal"
          (are [curator goal expectation] (= (get (h/course-by-goal curator goal)) expectation)
            user-id goal  course
            user-id "bla" nil
            :bla    goal  nil
            :bla    "bla" nil))

        (testing "it retrieves a course by curator and slug"
          (are [curator slug expectation] (= (get (h/course-by-slug curator slug)) expectation)
            user-id slug  course
            user-id "bla" nil
            :bla    goal  nil
            :bla    "bla" nil))))

    (testing "when query type is checkpoint"
      (let [new-checkpoint {:checkpoint-id :new}
            course         (update course :checkpoints #(conj % new-checkpoint))
            store          (sut/new {:courses [course]})
            get            (partial qa/get store :checkpoint)]

        (testing "it retrieves a checkpoint by slug"
          (are [course-id checkpoint-slug expectation]
              (= (get (h/checkpoint-by-slug course-id checkpoint-slug)) expectation)
            id         slug checkpoint
            missing-id slug nil))

        (testing "it retrieves a checkpoint by id"
          (are [course-id checkpoint-id expectation]
              (= (get (h/checkpoint course-id checkpoint-id)) expectation)
            id         :new new-checkpoint
            id         1    checkpoint
            missing-id :new nil
            missing-id 1    nil))))

    (testing "when query type is resources"
      (let [store (sut/new {:resources [resource]})
            get   (partial qa/get store :resources)]

        (testing "it retrieves the resources"
          (are [resource-ids expectation] (= (get resource-ids) expectation)
            [url]         [resource]
            [missing-url] nil))))

    (testing "when query type is resource"
      (let [store (sut/new {:resources [resource]})
            get   (partial qa/get store :resource)]

        (testing "it retrieves a resource"
          (are [url expectation] (= (get (h/resource url)) expectation)
            url         resource
            missing-url nil))))))
