(ns offcourse.system.viewmodels
  (:require [offcourse.viewmodels.checkpoint-view.index :as cpv]
            [offcourse.viewmodels.collection-view.index :as clv]
            [offcourse.viewmodels.course-view.index :as cov]))

(def viewmodels {:collection-view clv/new
                 :course-view cov/new
                 :checkpoint-view cpv/new})
