(ns offcourse.styles.components.viewer
  (:refer-clojure :exclude [rem + - * /])
  (:require [offcourse.styles.vocabulary :as v]
            [garden
             [selectors :as s]
             [arithmetic :refer [+ - * /]]
             [units :as u :refer [percent px rem]]]))

(defn viewer [{:keys [templates colors fonts units]}]
  [[v/viewer                 (merge  (:column-component   templates)
                                     (:paper              templates)
                                     {:overflow-y         :auto
                                      :flex               1})]
   [v/viewer--meta           (merge  ())]
   [v/viewer--content                {:display            :block
                                      :padding           (:full units)
                                      :max-width         (:max-content-width   units)}
    
    (for [header v/viewer-headers]   
    [[header                 (merge  (:title              templates)
                                     {:padding          [[(:one-and-half units) 0 (:sixth units) 0]]})
      [v/first                       {:padding          [[0 0 (:sixth units) 0]]}]]
     (for [next-header v/viewer-headers]
     [(s/+ header next-header)       {:padding          [[0 0 (:sixth units) 0]]}])])

    [v/viewer-header-1       (merge  {:font-size         (* 2.2 (:base-font units))
                                      :line-height       (* 2.0 (:base-line-height units))})]
    [v/viewer-header-2       (merge  {:font-size         (* 1.8 (:base-font units))
                                      :line-height       (* 1.8 (:base-line-height units))})]
    [v/viewer-header-3       (merge  {:font-size         (* 1.5 (:base-font units))
                                      :line-height       (* 1.5 (:base-line-height units))})] 
    [v/viewer-header-4       (merge  {:font-size         (* 1.25 (:base-font units))
                                      :line-height       (* 1.25 (:base-line-height units))})]
    [v/viewer-header-5       (merge  {:font-size         (* 1 (:base-font units))
                                      :line-height       (* 1 (:base-line-height units))})]
    [v/viewer-header-6       (merge  {:font-size         (* 0.8 (:base-font units))
                                      :line-height       (* 0.8 (:base-line-height units))})]
    [v/viewer-text           (merge  (:text               templates)
                                     {:padding          [[0 0 (:two-third units) 0]]})]
    [v/viewer-anchor         (merge  (:text               templates)
                                     (:border-default     templates)
                                     {:cursor             :pointer
                                      :padding          [[0 0 0 0]]})
     [v/hovered              (merge  (:border-highlighted templates))]]
    [v/viewer-strong         (merge  (:subtitle           templates)
                                     {:padding          [[0 0 (:two-third units) 0]]})]
    [v/viewer-em             (merge  (:text               templates)
                                     {:margin           [[0 0 (:two-third units) 0]]})]
    [v/viewer-ul             (merge  (:text               templates)
                                     {:list-style       [[:square :outside]]
                                      :padding          [[0 (:five units) (:two-third units) (:full units)]]})]
    [v/viewer-ol             (merge  (:text               templates)
                                     {:list-style       [[:decimal :outside]]
                                      :padding          [[0 (:five units) (:two-third units) (:full units)]]})]
    [v/viewer-li             (merge  (:text               templates)
                                     {:padding          [[0 0 (:two-third units) 0]]})
     [v/last                         {:padding          [[0 0 0 0]]}]]
    [v/viewer-image          (merge  {:display            :block
                                      :width             (percent 100)
                                      :padding          [[0 0 (:two-third units) 0]]})]
    [v/viewer-figcaption     (merge  (:text               templates)
                                     {:font-size         (* 0.8               (:base-font units))
                                      :line-height       (* 0.8               (:base-line-height units))
                                      :padding          [[0 (:five units) (:two-third units) (:full units)]]})]
    [v/viewer-blockquote     (merge  (:text               templates)
                                     (:recycled-paper     templates)
                                     (:border-quotes      templates)
                                     {:padding           (- (:full units) (:sixth units))
                                      :margin           [[0 0 (:two-third units) 0]]})]
    [v/viewer-pre            (merge  (:mono               templates)
                                     (:darkend-paper      templates)
                                     (:border-quotes      templates)
                                     (:border-highlighted templates)
                                     {:white-space        :pre-wrap
                                      :padding          [[(:third units) (:full units) (:third units) (- (:full units) (:sixth units))]]
                                      :margin           [[0 0 (:two-third units) 0]]})
     [v/viewer-code          (merge  (:darkend-paper      templates)
                                     {:display            :block})]]
    [v/viewer-code           (merge  (:mono               templates)
                                     {:display            :inline-block
                                      :color             (:dark colors)})]]])
