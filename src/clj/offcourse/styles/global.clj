(ns offcourse.styles.global)

(defn global [{:keys [base-component base-font]}]
  [[:*     {:margin      0
            :padding     0
            :font-family base-font
            :box-sizing  :border-box}]
   [:html  base-component]
   [:body base-component]
   [:#container base-component]])
