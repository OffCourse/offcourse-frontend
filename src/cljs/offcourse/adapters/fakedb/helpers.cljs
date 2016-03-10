(ns offcourse.adapters.fakedb.helpers
  (:require [clojure.string :as str]
            [faker.lorem :as lorem]
            [offcourse.fake-data.buzzwords :as bw]))

(defn rand-int-between [min max]
  (let [dev (- max min)]
    (+ (rand-int dev) min)))

(defn to-snake-case [str]
  (as-> str %
    (str/lower-case %)
    (str/split % #" ")
    (str/join "-" %)))

(def buzzwords (map to-snake-case bw/buzzwords))

(defn set-of-buzzwords [min max]
  (->> buzzwords
       shuffle
       (take (rand-int-between min max))
       (into #{})))

(defn make-title []
  (->> (lorem/words)
       (take (rand-int-between 3 8))
       (map #(str/capitalize %1))
       (str/join " ")))

(def body
  (->> (lorem/paragraphs (rand-int-between 8 15))
       (take (rand-int-between 10 40))))

(defn make-text [title]
  (->> (conj body (str "# " title))
       (str/join "\n\n")))

(def urls ["facebook.com"
           "google.com"
           "lifely.nl"
           "yahoo.com"
           "pinterest.com"
           "offcourse.io"])

(def users ["yeehaa" "greg" "r2j2" "reika" "charlotte" "marijn"])

(def flags [:featured :new :popular])

(def hashtags (atom (shuffle buzzwords)))

(defn generate-flags []
  (->> flags
       shuffle
       (take (rand-int 4))
       (into #{})))
