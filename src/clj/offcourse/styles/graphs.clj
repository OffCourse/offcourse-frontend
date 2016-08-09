(ns offcourse.styles.graphs
  (:refer-clojure :exclude [rem + - * /])
  (:require [garden
             [arithmetic :refer [* + /]]
             [units :as u :refer [percent px rem]]]
            [plumbing
             [core :refer [fnk]]
             [graph :as graph]]))

(defn -compose [graph config] ((graph/compile graph) config))

(def units-graph
  {:column               (fnk [full] (* full 14))
   :column-gap           (fnk [full] (* 1 full))
   :padded-column        (fnk [full] (* 12 full))
   :sidebar              (fnk [column column-gap] (+ column (* 2 column-gap)))
   :max-content-width    (fnk [full] (* 33 full))
   :map                  (fnk [column] (/ column 2))
   :four                 (fnk [full]  (* full 4))
   :five                 (fnk [full]  (* full 5))
   :three                (fnk [full] (* full 3))
   :two                  (fnk [full] (* full 2))
   :one-and-half         (fnk [full] (* full 1.5))
   :one-and-quarter      (fnk [full] (* full 1.25))
   :two-third            (fnk [third] (* third 2))
   :full                 (fnk [base-unit] (rem (/ base-unit 16)))
   :half                 (fnk [full] (/ full 2))
   :third                (fnk [full] (/ full 3))
   :sixth                (fnk [full] (/ full 6))
   :tenth                (fnk [full] (/ full 10))
   :fifteenth            (fnk [full] (/ full 15))
   :atom                 (fnk [full] (/ full 30))

   :banner-font                (fnk [base-font]         (* base-font          4))
   :banner-line-height         (fnk [base-line-height]  (* base-line-height   4))
   :large-font                 (fnk [base-font]         (* base-font          2.2))
   :large-line-height          (fnk [base-line-height]  (* base-line-height   1.8))
   :title-font                 (fnk [base-font]         (* base-font          1.5))
   :title-line-height          (fnk [base-line-height]  (* base-line-height   1.5))
   :subtitle-font              (fnk [base-font]         (* base-font          1))
   :subtitle-line-height       (fnk [base-line-height]  (* base-line-height   1))
   :base-font                  (fnk [atom]              (* atom 24))
   :base-line-height           (fnk [atom]              (* atom 30))
   :mono-font                  (fnk [atom]              (* atom 22))
   :mono-line-height           (fnk [atom]              (* atom 30))
   :label-font                 (fnk [base-font]         (* base-font          0.8))
   :label-line-height          (fnk [base-line-height]  (* base-line-height   0.5))
   })

(def templates-graph
  {:highlighted      (fnk [colors] {:background-color (:primary colors)
                                    :color            (:night colors)})
   :selected         (fnk [colors] {:background-color (:night colors)
                                    :color            (:day colors)})
   :paper            (fnk [colors] {:background-color (:day colors)
                                    :color            (:night colors)})
   :sheet            (fnk [paper borders] (merge paper
                                                 {:border-bottom (:default borders)}))
   :negative         (fnk [colors] {:background-color (:night colors)
                                    :color            (:day colors)})
   :recycled-paper   (fnk [colors] {:background-color (:light colors)
                                    :color            (:night colors)})
   :darkend-paper    (fnk [colors] {:background-color (:dark colors)
                                    :color            (:day colors)})

   :banner              (fnk [units fonts]     {:font-family        (:logo fonts)
                                                :font-size          (:banner-font units)
                                                :line-height        (:banner-line-height units)
                                                :font-weight         500})

   :logo                (fnk [fonts units]     {:font-family        (:logo fonts)
                                                :font-size          (:title-font units)
                                                :line-height        (:title-line-height units)
                                                :font-weight         500})

   :title               (fnk [units fonts]     {:font-family        (:title fonts)
                                                :font-size          (:title-font units)
                                                :line-height        (:title-line-height units)
                                                :font-weight         500})

   :form                (fnk [units fonts]     {:font-family        (:base fonts)
                                                :font-size          (:title-font units) 
                                                :line-height        (:title-line-height units)
                                                :font-weight         300})

   :list                (fnk [units fonts]     {:font-family        (:title fonts)
                                                :font-size          (:subtitle-font units)
                                                :line-height        (:title-line-height units)
                                                :font-weight         300})

   :mono                (fnk [units fonts]     {:font-family        (:mono fonts)
                                                :font-size          (:mono-font units)
                                                :line-height        (:mono-line-height units)
                                                :font-weight         300})   

   :subtitle            (fnk [units fonts]     {:font-family        (:title fonts)
                                                :font-size          (:subtitle-font units)
                                                :line-height        (:subtitle-line-height units)
                                                :font-weight         300})

   :text                (fnk [units fonts]     {:font-family        (:base fonts)
                                                :font-size          (:base-font units)
                                                :line-height        (:base-line-height units)
                                                :font-weight         300})

   :smalltitle          (fnk [units fonts]     {:font-family        (:title fonts)
                                                :font-size          (:label-font units)
                                                :line-height        (:label-line-height units)
                                                :font-weight         300})

   :label               (fnk [units fonts]     {:font-family        (:base fonts)
                                                :font-size          (:label-font units)
                                                :line-height        (:label-line-height units)
                                                :font-weight         300})

   ; old font
   :tiny-font        (fnk [units fonts label] label)

   :border-default      (fnk [units colors]    {:border-bottom      [[:solid (:sixth units) (:medium colors)]]})
   :border-thin         (fnk [units colors]    {:border-bottom      [[:solid (:atom units)  (:medium colors)]]})
   :border-quotes       (fnk [units colors]    {:border-left        [[:solid (:sixth units) (:medium colors)]]})
   :border-highlighted  (fnk [units colors]    {:border-color       [(:primary colors)]})

   :component        (fnk [] {:display        :flex
                              :flex-direction :column
                              :padding        0
                              :margin         0})
   :column-component (fnk [component] component)
   :row-component    (fnk [component] (merge component {:flex-direction :row}))
   :buttonless       (fnk [units] {:outline          :none
                                   :padding          [[0 (:third units)]]
                                   :border           :none})

   :list-item         (fnk [row-component recycled-paper title units]
                           (merge row-component recycled-paper title
                                  {:margin-bottom   (:sixth units)
                                   :align-items     :center
                                   :font-size       (:subtitle-font units)
                                   :padding         (:half units)
                                   :height          (:one-and-half units)}))
   :textbar          (fnk [units component buttonless logo negative]
                          (merge logo
                                 negative
                                 component
                                 buttonless))})

(def config-graph
  {:colors      (fnk [raw-colors base-color]
                     {:night   (:black raw-colors)
                      :dark    (:dark-gray   raw-colors)
                      :medium  (:medium-gray raw-colors)
                      :light   (:light-gray  raw-colors)
                      :very-light (:very-light-gray raw-colors)
                      :day     (:white raw-colors)
                      :primary (base-color raw-colors)})
   :breakpoints (fnk [raw-breakpoints]
                     (map (fn [{:keys [min-width max-width percent column-count]}]
                            {:min-width (px min-width)
                             :max-width (px max-width)
                             :percent   (u/percent percent)
                             :column-count column-count})
                          raw-breakpoints))
   :fonts       (fnk [raw-fonts base-font logo-font title-font mono-font]
                     {:base  base-font
                      :logo  logo-font
                      :title title-font
                      :mono  mono-font
                      :raw   (vals raw-fonts)})

   :borders     (fnk [units colors]
                     {:default [[:solid (:sixth units) (:medium colors)]]
                      :highlighted {:border-color [(:primary colors)]}})
   :units       (fnk [base-unit] (-compose units-graph {:base-unit base-unit}))
   :templates   (fnk [units fonts colors borders]
                     (-compose templates-graph {:units  units
                                                :fonts fonts
                                                :colors colors
                                                :borders borders}))})


(def compose (partial -compose config-graph))
