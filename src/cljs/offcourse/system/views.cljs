(ns offcourse.system.views
  (:require [offcourse.views.base :as bv]
            [offcourse.views.checkpoint :as cpv]
            [offcourse.views.new-user :as nuv]
            [offcourse.views.course :as cov]
            [offcourse.views.new-course :as ncv]
            [offcourse.views.collection :as clv]))

(def views
  {:loading    bv/graph
   :new-user-view   (merge bv/graph nuv/graph)
   :new-course-view (merge bv/graph ncv/graph)
   :course-view     (merge bv/graph cov/graph)
   :collection (merge bv/graph clv/graph)
   :checkpoint-view (merge bv/graph cpv/graph)})
