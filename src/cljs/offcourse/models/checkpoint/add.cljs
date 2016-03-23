(ns offcourse.models.checkpoint.add)

(defmulti add (fn [_ {:keys [type]}] type))

(defmethod add :tag [checkpoint {:keys [tag] :as q}]
  (update-in checkpoint [:tags] #(->> (conj % tag) (into #{}))))
