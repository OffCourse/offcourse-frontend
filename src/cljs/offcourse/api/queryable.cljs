(ns offcourse.api.queryable
  (:require [cljs.core.async :refer [<! chan]]
            [ajax.core :refer [POST]]
            [offcourse.protocols.convertible :as ci]
            [clojure.walk :as walk]
            [offcourse.protocols.queryable :as qa]
            [offcourse.protocols.responsive :as ri])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn handle-response [response]
  (let [{:keys [type error] :as response} (-> response
                                              walk/keywordize-keys)]
    (if-not error
      ((keyword type) response)
      {:error :not-found})))

(defn fetch-data [query]
  (let [c (chan)]
    (POST (str "https://6fp04c7v5e.execute-api.eu-west-1.amazonaws.com/staging/courses")
        {:headers {}
         :params (clj->js query)
         :format :json
         :handler #(go (>! c (handle-response %)))})
    c))

(defmulti fetch (fn [_ {:keys [type]}] type))

(defmethod fetch :collection [{:keys [repositories fetchables] :as api} {:keys [type] :as query}]
  (doseq [repository repositories]
    (go
      (let [result (remove nil? (<! (qa/fetch repository query)))]
        (if (or (:error result) (empty? result))
          (ri/respond api :not-found-data query)
          (when-let [converted (keep ci/to-course result)]
            (ri/respond api :found-data :courses converted)))))))

(defmethod fetch :course [{:keys [repositories fetchables] :as api} {:keys [course] :as query}]
  (println query)
  (doseq [repository repositories]
    (go
      (let [result (<! (qa/fetch repository :course course))]
        (when-not (:error result)
          (ri/respond api :found-data :course (ci/to-course result)))))))
