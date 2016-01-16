(ns offcourse.system.viewmodels
  (:require [offcourse.models.checkpoint-view.index :as cpv]
            [offcourse.models.collection-view.index :as clv]
            [offcourse.models.course-view.index :as cov]))

(def viewmodels {:collection-view clv/new
                 :course-view cov/new
                 :checkpoint-view cpv/new})
