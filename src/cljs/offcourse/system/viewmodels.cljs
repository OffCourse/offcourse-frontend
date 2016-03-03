(ns offcourse.system.viewmodels
  (:require [offcourse.viewmodels.checkpoint-view.index :as cpv]
            [offcourse.viewmodels.loading-view.index :as lv]
            [offcourse.viewmodels.collection-view.index :as clv]))

(def viewmodels {:collection-view clv/new
                 :loading-view    lv/new
                 :checkpoint-view cpv/new})
