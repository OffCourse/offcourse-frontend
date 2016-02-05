(ns offcourse.viewmodels.collection-view.queryable
  (:require [medley.core :as medley]
            [com.rpl.specter :refer [select select-first filterer ALL]]
            [offcourse.models.label :as lb]))
