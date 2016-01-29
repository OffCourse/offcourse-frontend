(set-env!
 :source-paths    #{"sass" "src/js" "src/clj" "src/cljs" "src/cljc"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs           "1.7.170-3"   :scope "test"]
                 [adzerk/boot-cljs-repl      "0.3.0"       :scope "test"]
                 [adzerk/boot-reload         "0.4.2"       :scope "test"]
                 [ring/ring-devel           "1.3.2"        :scope "test"]
                 [cljsjs/pouchdb                      "5.1.0-1"]
                 [hiccup "1.0.5"]
                 [metosin/ring-http-response "0.6.5"]
                 [cljsjs/react                        "0.14.3-0"]
                 [cljsjs/react-dom                    "0.14.3-1"]
                 [cljsjs/react-dom-server             "0.14.3-0"]
                 [cljsjs/react-grid-layout            "0.8.5-0"]
                 [com.cemerick/piggieback    "0.2.1"       :scope "test"]
                 [com.lucasbradstreet/cljs-uuid-utils "1.0.2"]
                 [com.stuartsierra/component          "0.3.1"]
                 [danlentz/clj-uuid                   "0.1.6"]
                 [env/faker                           "0.4.0"]
                 [hashobject/boot-s3 "0.1.2-SNAPSHOT"]
                 [mathias/boot-sassc         "0.1.5"      :scope "test"]
                 [medley                              "0.7.0"]
                 [compojure "1.4.0"]
                 [org.clojure/clojurescript           "1.7.189"]
                 [org.clojure/core.async              "0.2.374"]
                 [org.clojure/core.match              "0.3.0-alpha4"]
                 [org.clojure/tools.nrepl    "0.2.12"      :scope "test"]
                 [pandeiro/boot-http "0.7.1-SNAPSHOT" :scope "test"]
                 [prismatic/schema                    "1.0.4"]
                 [prismatic/plumbing "0.5.2"]
                 [com.rpl/specter "0.9.2"]
                 [rum                                 "0.6.0"]
                 [sablono                             "0.5.3"]
                 [bidi "1.25.0"]
                 [kibu/pushy "0.3.6"]
                 [cljsjs/fixed-data-table "0.4.6-0"]
                 [weasel                     "0.7.0"       :scope "test"]])

 (require
  '[adzerk.boot-cljs      :refer [cljs]]
  '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
  '[adzerk.boot-reload    :refer [reload]]
  '[pandeiro.boot-http    :refer [serve]]
  '[hashobject.boot-s3    :refer :all]
  '[mathias.boot-sassc    :refer [sass]])

 (deftask build []
   (comp (cljs)
         (sass :output-dir "css")
         (target)))

 (deftask run []
   (comp (serve :handler 'history-handler/app
                :reload true)
         (watch)
         (cljs-repl)
         (reload)
         (build)))

 (deftask production []
   (set-env! :source-paths #(conj % "src-prod/cljs"))
   (task-options! target {:dir #{"target/prod"}}
                  cljs   {:optimizations :advanced}
                  sass   {:output-style "compressed"})
   identity)

 (deftask development []
   (set-env! :source-paths #(conj % "src-dev/cljs" "src-dev/clj"))
   (task-options! target {:dir #{"target/dev"}}
                  cljs   {:optimizations :none
                          :source-map true}
                  reload {:on-jsload 'offcourse.main/reload}
                  sass   {:line-numbers true
                          :source-maps  true})
   identity)

 (deftask dev
   "Simple alias to run application in development mode"
   []
   (comp (development)
         (run)))

 (deftask prod
   "Simple alias to run application in production mode"
   []
   (comp (production)
         (build)))

 (deftask deploy
   []
   (task-options! s3-sync {:source "prod"
                           :bucket "offcourse-staging"
                           :access-key (get-sys-env "AWS_ACCESS_KEY" :required)
                           :secret-key (get-sys-env "AWS_SECRET_KEY" :required)})
   (comp (prod)
         (s3-sync)))
