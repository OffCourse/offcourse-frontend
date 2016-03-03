(ns offcourse.models.datastore.add-test
  #_(:require [offcourse.protocols.queryable :as qa]
            [offcourse.models.datastore.index :as sut]
            [offcourse.models.checkpoint :as  cp]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest testing is are]]))

#_(deftest models-datastore-add

  (let [id              123
        missing-id      223
        buzzword        :agile
        user-id         :yeehaa
        checkpoint      {:checkpoint-id 1
                         :resource-id   id}
        course          {:course-id   id
                         :curator     user-id
                         :hashtag     buzzword
                         :checkpoints [checkpoint]}
        collection-type :flags
        collection      {:collection-type collection-type
                         :collection-name buzzword
                         :course-ids      #{}}]

    (testing "it returns an error if given an non-exisiting query type"
      (is (= (qa/add (sut/new) :bla {})
             {:type :error :error :query-not-supported})))

    (testing "it returns the store by default"
      (let [types     [:checkpoint]
            store     (sut/new)
            responses (map #(qa/add store {:type %}) types)]
        (is (every? #(= store %) responses))))

    (testing "when query type is checkpoint"

      (testing "it does not change anything if the course does not exist"
        (let [store (sut/new {:courses [course]})
              add   (partial qa/add store :checkpoint)]
          (is (= (add (h/checkpoint missing-id :new)) store))))

      (testing "it does not change anything if the checkpoint-id is not :new"
        (let [store (sut/new {:courses [course]})
              add   (partial qa/add store :checkpoint)]
          (is (= (add (h/checkpoint id 2)) store))))

      (testing "adds the checkpoint if it does not exist yet"
        (let [store     (sut/new {:courses [course]})
              add       (partial qa/add store :checkpoint)
              new-store (add (h/checkpoint id :new))]
          (is (= (qa/check new-store :checkpoint
                           {:course-id     id
                            :checkpoint-id :new})) true)))

      (testing "it does not change anything if the course already exists"
        (let [checkpoint cp/placeholder
              course     (assoc course :checkpoints [checkpoint])
              store      (sut/new {:courses [course]})
              add        (partial qa/add store :checkpoint)]
          (is (= (add (h/checkpoint id :new)) store)))))))
