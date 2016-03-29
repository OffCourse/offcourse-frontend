(ns offcourse.views.components.label
  (:require [rum.core :as rum]
            [bidi.bidi :refer [path-for]]
            [clojure.string :as str]))

(defn titleize [string & {:keys [separator] :or {separator " "}}]
  (as-> string n
    (str/split n separator)
    (map #(str/capitalize %) n)
    (str/join separator n)))

(rum/defc label [{:keys [label-name] :as label} {:keys [collection-url]}]
  (let [{:keys [selected?]} (meta label)
        title (titleize (name label-name) :separator "-")]
    [:span.label {:data-selected selected?}
     [:a {:href (collection-url label-name)} (str title " ")]]))

(rum/defc labels [labels {:keys [collection-url] :as helpers}]
  (let [helpers (assoc helpers :collection-url (partial collection-url :tags))]
    [:.labels (map #(rum/with-key (label % helpers)
                      (:label-name %)) labels)]))

(rum/defc label-form [tag {:keys [save-tag update-tag]}]
  [:form.form {:on-submit save-tag}
   [:input.form--input {:placeholder "Tag"
                        :value tag
                        :on-change update-tag
                        :name "tag"}]
   #_[:input.button {:type "submit"
                     :data-button-type (name :icon)
                     :value "+"}]])
