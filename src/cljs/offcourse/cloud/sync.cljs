(ns offcourse.cloud.sync
  (:require [cljs.core.async :refer [<! chan >!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn sync [{:keys [profile-data]}]
  (let [c (chan)]
    (.synchronize @profile-data (clj->js {:onSuccess #(go (>! c "success"))
                                          :onFailure #(go (>! c %1))
                                          :onConflict #(go (>! c "conflict"))}))
    c))
