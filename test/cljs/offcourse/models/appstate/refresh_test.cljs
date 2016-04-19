(ns offcourse.models.appstate.refresh-test
  (:require [cljs.test :refer-macros [are deftest is testing]]
            [com.rpl.specter :refer [select-first]]
            [offcourse.models.fixtures :as fx]
            [offcourse.models.appstate.helpers :as h]
            [offcourse.models.appstate.index :as sut]
            [offcourse.models.appstate.paths :as paths]
            [offcourse.models.course.index :as co]
            [offcourse.protocols.queryable :as qa]))

(deftest models-appstate-refresh

  (testing "when query type is non-existing"
    (is (= (qa/refresh (sut/new) :bla)
           {:type :error :error :query-not-supported})))

  (testing "when query type is user"
    (let [query {:type :user
                 :user {:user-name fx/user-name}}
          state (qa/refresh (sut/new) query)]
      (is (= fx/user-name (get-in state [:user :name])))))

  (testing "when query type is collections"
    (let [store (sut/new {:collections [(assoc fx/collection :course-ids #{})]})]

      (testing "it adds a new course"
        (let [store              (qa/refresh store :collections fx/course)
              curator-collection (qa/get store :collection {:collection-type :curators
                                                            :collection-name fx/user-name})
              flag-collection    (qa/get store :collection {:collection-type :flags
                                                            :collection-name fx/flag-type})
              tag-collection     (qa/get store :collection {:collection-type :tags
                                                            :collection-name fx/buzzword})]
          (is (contains? (:course-ids tag-collection) fx/id))
          (is (contains? (:course-ids flag-collection) fx/id))
          (is (contains? (:course-ids curator-collection) fx/id))))))

  (testing "when query type is collection"
    (let [store (sut/new {:collections [(assoc fx/collection :course-ids #{fx/id})]})]

      (testing "it adds new collections"
        (let [collection       (assoc fx/collection :collection-name fx/other-buzzword)
              store            (qa/refresh store :collection fx/collection)
              collection-names (map :collection-name (:collections store))]
          (are [value actual] (= (h/contains-val? collection-names value) actual)
            fx/buzzword       true
            fx/other-buzzword false)))

      (testing "it merges existing and new course-ids in a collection"
        (let [collection (assoc fx/collection :course-ids #{fx/other-id})
              store      (qa/refresh store :collection collection)
              ids        (select-first [(paths/collection fx/collection-type fx/buzzword)
                                        :course-ids] store)]
          (are [value actual] (= (contains? ids value) actual)
            fx/id         true
            fx/other-id   true
            fx/missing-id false)))))

  (testing "when query type is courses"
    (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

      (testing "it adds new courses"
        (let [query {:type    :courses
                     :courses (courses [fx/id fx/other-id])}
              store (sut/new {:courses (courses [fx/yet-another-id])})
              ids   (map :course-id (:courses (qa/refresh store query)))]
          (are [value actual] (= (h/contains-val? ids value) actual)
            fx/id             true
            fx/other-id       true
            fx/yet-another-id true
            fx/missing-id     false)))

      (testing "does not add courses that are already in store"
        (let [query {:type    :courses
                     :courses (courses [fx/id fx/other-id])}
              store (sut/new {:courses (courses [fx/id])})
              ids   (map :course-id (:courses (qa/refresh store query)))]
          (is (= (count (filter #(= fx/id %) ids)) 1))))))

  (testing "when query type is course"
    (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

      (testing "it adds a new course"
        (let [course (assoc fx/course :course-id fx/other-id)
              store  (sut/new {:courses (courses [fx/id])})
              ids    (map :course-id (:courses (qa/refresh store :course course)))]

          (are [value actual] (= (h/contains-val? ids value) actual)
            fx/id         true
            fx/other-id   true
            fx/missing-id false)))

      (testing "updates  a course that is already in store"
        (let [store  (-> (sut/new {:courses [fx/course]})
                         (qa/refresh :toggle-checkpoint (assoc fx/checkpoint :course-id fx/id)))
              checkpoint (qa/get store :checkpoint (assoc fx/checkpoint :course-id fx/id))]
          (is (:completed? checkpoint))))

      (testing "does not add a course that is already in store"
        (let [course {:course-id fx/id}
              store  (sut/new {:courses (courses [fx/id])})
              ids    (map :course-id (:courses (qa/refresh store :course fx/course)))]
          (is (= (count (filter #(= fx/id %) ids)) 1))))))

  (testing "when query type is resources"
    (letfn [(resources [urls] (map (fn [url] {:url url}) urls))]

      (testing "it adds new resources"
        (let [query {:type      :resources
                     :resources (resources [fx/url fx/other-url])}
              store (sut/new {:resources (resources [fx/yet-another-url])})
              urls  (map :url (:resources (qa/refresh store query)))]
          (are [value actual] (= (h/contains-val? urls value) actual)
            fx/url         true
            fx/other-url    true
            fx/yet-another-url    true
            fx/missing-url false)))

      (testing "does not add resources that are already in store"
        (let [query {:type      :resources
                     :resources (resources [fx/url fx/other-url])}
              store (sut/new {:resources (resources [fx/url])})
              urls  (map :url (:resources (qa/refresh store query)))]
          (is (= (count (filter #(= fx/url %) urls)) 1))))

      (testing "does not add two of the same resources that are not in store"
        (let [query {:type      :resources
                     :resources (resources [fx/other-url fx/yet-another-url])}
              store (sut/new {:resources (resources [fx/url])})
              urls  (map :url (:resources (qa/refresh store query)))]
          (is (= (count (filter #(= fx/other-url %) urls)) 1))))))

  (testing "when query type is resource"
    (let [resources (fn [urls] (map (fn [url] {:url url}) urls))]

      (testing "it adds a new resource"
        (let [store (sut/new {:resources (resources [fx/other-url])})
              urls  (map :url (:resources (qa/refresh store :resource fx/resource)))]

          (are [value actual] (= (h/contains-val? urls value) actual)
            fx/url         true
            fx/other-url    true
            fx/missing-url false)))

      (testing "does not add a resource that is already in store"
        (let [store (sut/new {:resources [fx/resource]})
              urls  (map :url (:resources (qa/refresh store :resource fx/resource)))]
          (is (= (count (filter #(= fx/url %) urls)) 1)))))))
