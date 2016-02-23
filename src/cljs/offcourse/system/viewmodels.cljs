(ns offcourse.system.viewmodels
  (:require [offcourse.viewmodels.checkpoint-view.index :as cpv]
            [offcourse.viewmodels.collection-view.index :as clv]))

(def viewmodels {:collection-view clv/new
                 :checkpoint-view cpv/new})
