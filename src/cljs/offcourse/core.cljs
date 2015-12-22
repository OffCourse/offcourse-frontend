(ns offcourse.core
  (:require [cljs.core.async :refer [<!]]
            [offcourse.views.debug :as debug])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn render [response]
  (debug/render response))
