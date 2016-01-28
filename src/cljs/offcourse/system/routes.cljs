(ns offcourse.system.routes)

(def routes ["/" {[[keyword :collection-name]] :home-view
                  ["courses/" [keyword :curator] "/" [keyword :hashtag]] :course-view
                  [[keyword :collection-type] "/" [keyword :collection-name]] :collection-view
                  true  :home-view}])
