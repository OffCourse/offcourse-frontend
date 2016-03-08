(ns offcourse.models.appstate.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.protocols.queryable :as qa :refer [Queryable]]))

(deftest models-appstate-refresh
  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        url             "http://offcourse.io"
        missing-url     "http://gibbon.co"
        course          {:course-id id
                         :curator   user-id
                         :hashtag   buzzword}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}
        resource        {:url url}]

    (testing "when query type is non-existing"
      (is (= (qa/refresh (sut/new) :bla)
             {:type :error :error :query-not-supported})))

    (testing "when query type is appstate"

      (let [query {:type     :appstate
                   :appstate {:view-type :course-view
                              :data-deps {:course course}}}
            state (qa/refresh (sut/new) query)]
          (is (= :course-view (:view-type state)))))

    (testing "when query type is user"

      (let [query {:type :user
                   :user {:name :yeehaa}}
            state (qa/refresh (sut/new) query)]
        (is (= :yeehaa (get-in state [:user :name])))))

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
          (let [course {:course-id 234}
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

        #_(testing "it adds new resources"
            (let [query {:type      :resources
                         :resources (resources [url "http://bla.com"])}
                  store (sut/new {:resources (resources ["http://blabla.com"])})
                  urls  (map :url (:resources (qa/refresh store query)))]
            (are [value actual] (= (h/contains-val? urls value) actual)
              url                 true
              "http://bla.com"    true
              "http://blabla.com" true
              missing-url         false)))

        (testing "does not add resources that are already in store"
          (let [query {:type      :resources
                       :resources (resources [url "http://bla.com"])}
                store (sut/new {:resources (resources [url])})
                urls  (map :url (:resources (qa/refresh store query)))]
            (is (= (count (filter #(= url %) urls)) 1))))))

    (testing "when query type is resource"
      (let [resources (fn [urls] (map (fn [url] {:url url}) urls))]

        (testing "it adds a new resource"
          (let [store (sut/new {:resources (resources ["http://bla.com"])})
                urls  (map :url (:resources (qa/refresh store :resource resource)))]

            (are [value actual] (= (h/contains-val? urls value) actual)
              url              true
              "http://bla.com" true
              missing-url      false)))

        (testing "does not add a resource that is already in store"
          (let [store (sut/new {:resources [resource]})
                urls  (map :url (:resources (qa/refresh store :resource resource)))]
            (is (= (count (filter #(= url %) urls)) 1))))))))
