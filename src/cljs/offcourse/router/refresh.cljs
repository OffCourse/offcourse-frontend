(ns offcourse.router.refresh
  (:require [bidi.bidi :as bidi]
            [offcourse.protocols.responsive :as ri]
            [pushy.core :as pushy]
            [offcourse.protocols.convertible :as cv]))

(defn viewmodel->url [viewmodel routes]
  (cv/to-url viewmodel routes))

(defn refresh [{:keys [history routes url-helpers responses]} {:keys [state] :as query}]
  (let [{:keys [type dependencies] :as viewmodel} (-> state :viewmodel)
        old-url (pushy/get-token history)
        new-url (viewmodel->url viewmodel routes)]
    (when-not (= old-url new-url)
      (pushy/replace-token! history new-url))))
