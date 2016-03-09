(ns offcourse.adapters.fakedb.implementations.bootstrappable
  (:require [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn bootstrap [db]
  (go (ri/respond db :db-ready)))
