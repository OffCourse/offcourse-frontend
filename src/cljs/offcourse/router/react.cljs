(ns offcourse.router.react
  (:require [shared.protocols.convertible :as cv]
            [pushy.core :as pushy]
            [shared.specs.core :as specs]
            [cljs.spec :as spec]))

(defmulti react (fn [_ [_ payload]] (first (spec/conform ::specs/payload payload))))

(defmethod  react :appstate [{:keys [history routes url-helpers responses]} [_ payload]]
  (let [{:keys [type] :as viewmodel} (-> payload :viewmodel)
        old-url (pushy/get-token history)
        new-url (cv/to-url viewmodel routes)]
    (when-not (= old-url new-url)
      (pushy/replace-token! history new-url))))

(defmethod react :default [_ _] nil)
