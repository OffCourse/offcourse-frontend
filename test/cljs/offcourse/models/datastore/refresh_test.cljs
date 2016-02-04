(ns offcourse.models.datastore.refresh-test
  (:require [offcourse.models.datastore.refresh :refer [refresh]]
            [offcourse.models.datastore.helpers :as h]
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

    (testing "when query type is collection-names"

      (testing "it sets the has-collection-names? flag"
        (let [query (h/query :collection-names)
              store (refresh {} query)]
          (is (= (:has-collection-names? store) true))))

      (testing "it merges existing and new collection names"
        (let [query            (h/query :collection-names collection-type [:agile])
              collections      {:agile      collection
                                :netiquette (assoc collection :collection-name :nettiquette)}
              store            (refresh {:collections {collection-type collections}} query)
              collection-names (keys (get-in store [:collections collection-type]))]
          (are [value actual] (= (h/contains-val? collection-names value) actual)
            :agile          true
            :netiquette     true
            :bla            false))))


    (testing "when query type is collection"
      (let [collections {buzzword (assoc collection :course-ids #{123})}
            store {:collections {collection-type collections}}]

        (testing "it adds new collections"
          (let [query            {:type       :collection
                                  :collection (assoc collection :collection-name :taurus)}
                store            (refresh store query)
                collection-names (keys (get-in store [:collections collection-type]))]
            (are [value actual] (= (h/contains-val? collection-names value) actual)
              buzzword     true
              :agile       true
              :bla         false)))

      (testing "it merges existing and new course-ids in a collection"
        (let [query {:type       :collection
                     :collection (assoc collection :course-ids #{129})}
              store (refresh store query)
              ids   (get-in store [:collections collection-type buzzword :course-ids])]
          (are [value actual] (= (contains? ids value) actual)
            id           true
            129          true
            missing-id   false)))))


    (testing "when query type is courses"
      (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

        (testing "it adds new courses"
          (let [query {:type :courses
                       :courses (courses [id 234])}
                store {:courses (courses [567])}
                ids   (map :course-id (:courses (refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              567          true
              missing-id   false)))

        (testing "does not add courses that are already in store"
          (let [query {:type :courses
                       :courses (courses [id 234])}
                store {:courses (courses [id])}
                ids   (map :course-id (:courses (refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))


    (testing "when query type is course"
      (letfn [(courses [ids] (map (fn [id] {:course-id id}) ids))]

        (testing "it adds a new course"
          (let [query {:type :course
                       :course {:course-id 234}}
                store {:courses (courses [id])}
                ids   (map :course-id (:courses (refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              missing-id   false)))

        (testing "does not add a course that is already in store"
          (let [query {:type   :course
                       :course {:course-id id}}
                store {:courses (courses [id])}
                ids   (map :course-id (:courses (refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is resources"
      (letfn [(resources [ids] (map (fn [id] {:resource-id id}) ids))
              (resources-map [ids]
                (into {} (map (fn [{:keys [resource-id] :as resource}]
                                [resource-id resource]) (resources ids))))]

        (testing "it adds new resources"
          (let [query {:type :resources
                       :resources (resources [id 234])}
                store {:resources (resources-map [567])}
                ids   (keys (:resources (refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              567          true
              missing-id   false)))

        (testing "does not add resources that are already in store"
          (let [query {:type   :resource
                       :resources (resources [id 234])}
                store {:resources (resources-map [id])}
                ids   (keys (:resources (refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))

    (testing "when query type is resource"
      (letfn [(resources [ids] (map (fn [id] {:resource-id id}) ids))
              (resources-map [ids]
                (into {} (map (fn [{:keys [resource-id] :as resource}]
                                [resource-id resource]) (resources ids))))]

        (testing "it adds a new resource"
          (let [query {:type :resource
                       :resource {:resource-id 234}}
                store {:resources (resources-map [id])}
                ids   (keys (:resources (refresh store query)))]
            (are [value actual] (= (h/contains-val? ids value) actual)
              id           true
              234          true
              missing-id   false)))

        (testing "does not add a resource that is already in store"
          (let [query {:type   :resource
                       :resource {:resource-id id}}
                store {:resources (resources-map [id])}
                ids   (keys (:resources (refresh store query)))]
            (is (= (count (filter #(= id %) ids)) 1))))))))
