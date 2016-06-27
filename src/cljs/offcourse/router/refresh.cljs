(ns offcourse.router.refresh
  (:require [offcourse.protocols.convertible :as cv]
            [pushy.core :as pushy]))

(defn refresh [{:keys [history routes url-helpers responses]} {:keys [payload] :as query}]
  (let [{:keys [type] :as viewmodel} (-> payload :appstate :viewmodel)
        old-url (pushy/get-token history)
        new-url (cv/to-url viewmodel routes)]
    (when-not (= old-url new-url)
      (pushy/replace-token! history new-url))))
