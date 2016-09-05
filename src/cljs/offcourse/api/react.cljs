(ns offcourse.api.react
  (:require [cljs.spec :as spec]
            [cljs.spec.test :as stest]
            [shared.protocols.responsive :as ri]
            [shared.specs.core :as specs]))

(spec/fdef react :args (spec/cat :component any? :event ::specs/event))

(defn react [{:keys [component-name] :as api} event] (ri/send api (into [component-name] event)))

(stest/instrument `react)
