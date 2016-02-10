(ns offcourse.styles.global)

(defn global [{:keys [base-component base-font]}]
  [[:*     {:margin      0
            :padding     0
            :font-family base-font
            :user-select  :none
            :box-sizing  :border-box}]
   [:html  base-component]
   [:body  (merge base-component {:overflow-y :hidden})]
   [:#container base-component]])
