(ns offcourse.api.implementations.responsive
  (:require [cljs.core.async :refer [<! >! timeout]])
  (:require-macros [cljs.core.async.macros :refer [go-loop go]]))

(defn respond [{:keys [output-channel input-channel actions] :as this}]
  (go-loop []
    (>! output-channel {:type :component-initialized
                        :payload this})
    (let [{:keys [type payload]} (<! input-channel)
          response ((type actions) this payload)]
      (>! output-channel (<! response))
      (recur))))
