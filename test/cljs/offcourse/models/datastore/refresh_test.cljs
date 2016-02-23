(ns offcourse.models.datastore.refresh-test
  (:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.datastore.helpers :as h]
            [offcourse.models.datastore.paths :as paths]
            [com.rpl.specter :refer [select select-first transform filterer ALL]]
            [cljs.test :refer-macros [deftest testing is are]]))

(deftest models-datastore-refresh
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

    #_(testing "when query type is collection-names"

      (testing "it sets the has-collection-names? flag"
        (let [store (qa/refresh (sut/new) :collection-names [])]
          (is (:collection-names store) true)))

      (testing "it merges existing and new collection names"
        (let [collection2      (assoc collection :collection-name :netiquette)
              store            (-> (sut/new {:collections [collection collection2]})
                                   (qa/refresh :collection-names {collection-type [:agile]}))
              collection-names (map :collection-name (:collections store))]
          (are [value actual] (= (h/contains-val? collection-names value) actual)
            :agile          true
            :netiquette     true
            :bla            false))))

    (testing "when query type is collection"
      (let [store       (sut/new {:collections [(assoc collection :course-ids #{123})]})]

        (testing "it adds new collections"
          (let [collection       (assoc collection :collection-name :taurus)
                store            (qa/refresh store :collection collection)
                collection-names (map :collection-name (:collections store))]
            (are [value actual] (= (h/contains-val? collection-names value) actual)
              buzzword     true
              :agile       true
              :bla         false)))

        (testing "it merges existing and new course-ids in a collection"
          (let [collection (assoc collection :course-ids #{129})
                store (qa/refresh store :collection collection)
                ids   (select-first [(paths/collection collection-type buzzword) :course-ids] store)]
            (are [value actual] (= (contains? ids value) actual)
              id           true
              129          true
              missing-id   false)))))

    (testing "when query type is courses"
      (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

        (testing "it adds new courses"
          (let [query {:type    :courses
                       :courses (courses [id 234])}
                store (sut/new {:courses (courses [567])})
                ids   (map :course-id (:courses (qa/refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              567          true
              missing-id   false)))

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
                store (sut/new {:courses (courses [id])})
                ids   (map :course-id (:courses (qa/refresh store :course course)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              missing-id   false)))

        (testing "does not add a course that is already in store"
          (let [course {:course-id id}
                store (sut/new {:courses (courses [id])})
                ids   (map :course-id (:courses (qa/refresh store :course course)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is resources"
      (letfn [(resources [ids] (map (fn [id] {:resource-id id}) ids))
              (resources-map [ids]
                (into {} (map (fn [{:keys [resource-id] :as resource}]
                                [resource-id resource]) (resources ids))))]

        (testing "it adds new resources"
          (let [query {:type      :resources
                       :resources (resources [id 234])}
                store (sut/new {:resources (resources-map [567])})
                ids   (keys (:resources (qa/refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              567          true
              missing-id   false)))

        (testing "does not add resources that are already in store"
          (let [query {:type      :resource
                       :resources (resources [id 234])}
                store (sut/new {:resources (resources-map [id])})
                ids   (keys (:resources (qa/refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is resource"
      (let [resources     (fn [ids] (map (fn [id] {:resource-id id}) ids))
            resources-map (fn [ids] (into {} (map (fn [{:keys [resource-id] :as resource}]
                                                    [resource-id resource]) (resources ids))))]

        (testing "it adds a new resource"
          (let [resource {:resource-id 234}
                store    (sut/new {:resources (resources-map [id])})
                ids      (keys (:resources (qa/refresh store :resource resource)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              missing-id   false)))

        (testing "does not add a resource that is already in store"
          (let [resource {:resource-id id}
                store    (sut/new {:resources (resources-map [id])})
                ids      (keys (:resources (qa/refresh store :resource resource)))]
            (is (= (count (filter #(= id %) ids)) 1))))))))
