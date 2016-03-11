(ns offcourse.system.views
  (:require [offcourse.views.base :as bv]
            [offcourse.views.checkpoint :as cpv]
            [offcourse.views.new-course :as ncv]
            [offcourse.views.collection :as clv]))

(def views
  {:loading-view    bv/graph
   :course-view (merge bv/graph ncv/graph)
   :collection-view (merge bv/graph clv/graph)
   :checkpoint-view (merge bv/graph cpv/graph)})
