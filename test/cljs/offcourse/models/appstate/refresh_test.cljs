(ns offcourse.models.appstate.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.collection :as cl]
            [offcourse.models.course.index :as co]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa]))

(deftest models-appstate-refresh
  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        url             "http://offcourse.io"
        new-url1        "http://bla.com"
        new-url2        "http://blabla.com"
        missing-url     "http://facebook.co"
        collection-type :flags
        course          (co/new {:course-id id
                         :flags     #{collection-type}
                         :checkpoints [{:checkpoint-id id :tags #{buzzword}}]
                         :curator   user-id
                         :hashtag   buzzword})
        collection      (cl/new {:collection-type collection-type
                                 :collection-name buzzword
                                 :course-ids      #{}})
        resource        {:url url}]

    (testing "when query type is non-existing"
      (is (= (qa/refresh (sut/new) :bla)
             {:type :error :error :query-not-supported})))

    #_(testing "when query type is view"

        (let [query {:type      :view
                     :view-data {:view-type :course-view
                                 :data-deps {:course course}}}
              state (qa/refresh (sut/new) query)]
        (is (= :course-view (:view-type state)))))

    (testing "when query type is user"

      (let [query {:type :user
                   :user {:name :yeehaa}}
            state (qa/refresh (sut/new) query)]
        (is (= :yeehaa (get-in state [:user :name])))))

    (testing "when query type is collections"
      (let [store (sut/new {:collections [(assoc collection :course-ids #{})]})]

        (testing "it adds a new course"
          (let [store              (qa/refresh store :collections course)
                curator-collection (qa/get store :collection {:collection-type :curators
                                                              :collection-name user-id})
                flag-collection    (qa/get store :collection {:collection-type :flags
                                                              :collection-name collection-type})
                tag-collection     (qa/get store :collection {:collection-type :tags
                                                              :collection-name buzzword})]
            (is (contains? (:course-ids tag-collection) id))
            (is (contains? (:course-ids flag-collection) id))
            (is (contains? (:course-ids curator-collection) id))))))

    (testing "when query type is collection"
      (let [store (sut/new {:collections [(assoc collection :course-ids #{123})]})]

        (testing "it adds new collections"
          (let [collection       (assoc collection :collection-name :taurus)
                store            (qa/refresh store :collection collection)
                collection-names (map :collection-name (:collections store))]
            (are [value actual] (= (h/contains-val? collection-names value) actual)
              buzzword true
              :agile   true
              :bla     false)))

        (testing "it merges existing and new course-ids in a collection"
          (let [collection (assoc collection :course-ids #{129})
                store      (qa/refresh store :collection collection)
                ids        (select-first [(paths/collection collection-type buzzword) :course-ids] store)]
            (are [value actual] (= (contains? ids value) actual)
              id         true
              129        true
              missing-id false)))))

    (testing "when query type is courses"
      (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

        (testing "it adds new courses"
          (let [query {:type    :courses
                       :courses (courses [id 234])}
                store (sut/new {:courses (courses [567])})
                ids   (map :course-id (:courses (qa/refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id         true
              234        true
              567        true
              missing-id false)))

        (testing "does not add courses that are already in store"
          (let [query {:type    :courses
                       :courses (courses [id 234])}
                store (sut/new {:courses (courses [id])})
                ids   (map :course-id (:courses (qa/refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is course"
      (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

        (testing "it adds a new course"
          (let [course (co/new {:course-id 234})
                store  (sut/new {:courses (courses [id])})
                ids    (map :course-id (:courses (qa/refresh store :course course)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id         true
              234        true
              missing-id false)))

        (testing "does not add a course that is already in store"
          (let [course {:course-id id}
                store  (sut/new {:courses (courses [id])})
                ids    (map :course-id (:courses (qa/refresh store :course course)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is resources"
      (letfn [(resources [urls] (map (fn [url] {:url url}) urls))]

        (testing "it adds new resources"
          (let [query {:type      :resources
                       :resources (resources [url new-url1])}
                store (sut/new {:resources (resources [new-url2])})
                urls  (map :url (:resources (qa/refresh store query)))]
            (are [value actual] (= (h/contains-val? urls value) actual)
              url         true
              new-url1    true
              new-url2    true
              missing-url false)))

        (testing "does not add resources that are already in store"
          (let [query {:type      :resources
                       :resources (resources [url new-url1])}
                store (sut/new {:resources (resources [url])})
                urls  (map :url (:resources (qa/refresh store query)))]
            (is (= (count (filter #(= url %) urls)) 1))))

        (testing "does not add two of the same resources that are not in store"
          (let [query {:type      :resources
                       :resources (resources [new-url1 new-url1])}
                store (sut/new {:resources (resources [url])})
                urls  (map :url (:resources (qa/refresh store query)))]
            (is (= (count (filter #(= new-url1 %) urls)) 1))))))

    (testing "when query type is resource"
      (let [resources (fn [urls] (map (fn [url] {:url url}) urls))]

        (testing "it adds a new resource"
          (let [store (sut/new {:resources (resources [new-url1])})
                urls  (map :url (:resources (qa/refresh store :resource resource)))]

            (are [value actual] (= (h/contains-val? urls value) actual)
              url         true
              new-url1    true
              missing-url false)))

        (testing "does not add a resource that is already in store"
          (let [store (sut/new {:resources [resource]})
                urls  (map :url (:resources (qa/refresh store :resource resource)))]
            (is (= (count (filter #(= url %) urls)) 1))))))))
