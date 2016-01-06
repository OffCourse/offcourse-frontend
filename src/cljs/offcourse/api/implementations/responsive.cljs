(ns offcourse.api.implementations.responsive
  (:require [cljs.core.async :refer [<!]]
            [clojure.set :as set]
            [offcourse.protocols.queryable :as qa]
            [cljs.core.match :refer-macros [match]]
            [offcourse.protocols.convertible :as ci]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))
