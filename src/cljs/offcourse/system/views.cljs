(ns offcourse.system.views
  (:require [offcourse.views.collection :as collection]
            [offcourse.views.checkpoint :as checkpoint]))

(def views {:collection-view collection/view
            :checkpoint-view checkpoint/view})
