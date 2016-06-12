(ns offcourse.router.refresh
  (:require [offcourse.protocols.convertible :as cv]
            [pushy.core :as pushy]))

(defn viewmodel->url [viewmodel routes]
  (cv/to-url viewmodel routes))

(defn refresh [{:keys [history routes url-helpers responses]} {:keys [state] :as query}]
  (let [{:keys [type] :as viewmodel} (-> state :viewmodel)
        old-url (pushy/get-token history)
        new-url (viewmodel->url viewmodel routes)]
    (when-not (= old-url new-url)
      (pushy/replace-token! history new-url))))
