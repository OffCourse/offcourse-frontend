(ns offcourse.protocol-extensions.convertible
  (:require [cuerdas.core :as str]
            [shared.models.checkpoint.index :refer [Checkpoint]]
            [shared.models.course.index :as co :refer [Course]]
            [shared.models.viewmodel.index :as viewmodel]
            [shared.protocols.convertible :as cv :refer [Convertible]]))

(extend-protocol Convertible
  Checkpoint
  (-to-url [{:keys [task] :as cp} {:keys [goal organization curator] :as course} routes]
    (let [viewmodel (viewmodel/create :checkpoint-view {:checkpoint-slug (str/slugify task)
                                                        :organization organization
                                                        :course-slug (str/slugify goal)
                                                        :curator curator})]
      (cv/to-url viewmodel routes)))
  Course
  (-to-url [{:keys [curator organization goal]} routes]
    (let [viewmodel (viewmodel/create :course-view {:curator curator
                                                    :organization organization
                                                    :course-slug (str/slugify goal)})]
      (cv/to-url viewmodel routes))))
