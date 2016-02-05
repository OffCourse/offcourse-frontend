(ns offcourse.viewmodels.course-view.queryable
  (:require [offcourse.models.course :as co]
            [offcourse.models.label :as lb]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [cljs.pprint :as pprint]))
