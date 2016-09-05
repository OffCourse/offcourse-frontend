(ns offcourse.system.routes)

(def home-route        [:collection-name])
(def curator-routes    ["users/" :curator])
(def org-routes        ["org/" :organization])
(def new-user-route    "signup")
(def course-routes     (conj curator-routes "/courses/" :course-slug))
(def course-org-routes (conj org-routes "/users/" :curator "/courses/" :course-slug))
(def collection-routes [:collection-type "/" :collection-name])
(def checkpoint-routes (conj course-routes "/checkpoints/" :checkpoint-slug))
(def checkpoint-org-routes (conj course-org-routes "/checkpoints/" :checkpoint-slug))

(def table ["/" {course-org-routes     :course-org-view
                 checkpoint-org-routes :checkpoint-org-view
                 checkpoint-routes     :checkpoint-view
                 new-user-route        :new-user-view
                 collection-routes     :collection-view
                 course-routes         :course-view
                 home-route            :home-view
                 true                  :home-view}])
