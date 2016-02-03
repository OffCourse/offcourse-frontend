(ns offcourse.models.datastore.refresh-test
  (:require [offcourse.models.datastore.refresh :refer [refresh]]
            [offcourse.models.datastore.fixtures :as fx]
            [offcourse.models.datastore.helpers :as h]
            [cljs.test :refer-macros [deftest is are]]))

(def collections {fx/collection-type {fx/collection-name fx/collection}})

(deftest sets-has-collection-names-flag
  (let [query (h/query :collection-names)
        store (refresh {} query)]
    (is (= (:has-collection-names? store) true))))

(deftest merges-collection-names
  (let [query (h/query :collection-names
                       fx/collection-type [:agile])
        store (refresh {:collections collections} query)
        collection-names (keys (get-in store [:collections fx/collection-type]))]
    (are [value actual] (= (h/contains-val? collection-names value) actual)
      :taurus     true
      :agile      true
      :bla        false)))

(deftest adds-new-collections
  (let [collection-name :agile
        query (h/query :collection :collection-type fx/collection-type
                       :collection-name collection-name
                       :course-ids #{19})
        store (refresh {:collections collections} query)
        collection-names (keys (get-in store [:collections fx/collection-type]))]
    (are [value actual] (= (h/contains-val? collection-names value) actual)
      :taurus     true
      :agile      true
      :bla        false)))

(deftest merges-course-ids
  (let [query (h/query :collection :collection-type fx/collection-type
                       :collection-name fx/collection-name
                       :course-ids #{129})
        store (refresh {:collections collections} query)
        ids   (get-in store [:collections fx/collection-type fx/collection-name :course-ids])]
    (are [value actual] (= (contains? ids value) actual)
      fx/course-id true
      129          true
      540          false)))

