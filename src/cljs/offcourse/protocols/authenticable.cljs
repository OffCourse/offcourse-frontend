(ns offcourse.protocols.authenticable)

(defprotocol Authenticable
  (-init [this])
  (-sign-in [this])
  (-sign-out [this]))

(defn sign-in [this]
  (-sign-in this))

(defn sign-out [this]
  (-sign-out this))

(defn init [this]
  (-init this))
