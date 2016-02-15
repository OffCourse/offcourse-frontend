(set-env!
 :source-paths    #{"src/js" "src/cljs" "src/cljc"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs              "1.7.170-3"      :scope "test"]
                 [adzerk/boot-cljs-repl         "0.3.0"          :scope "test"]
                 [adzerk/boot-reload            "0.4.2"          :scope "test"]
                 [ring/ring-devel               "1.3.2"          :scope "test"]
                 [com.cemerick/piggieback       "0.2.1"          :scope "test"]
                 [org.clojure/tools.nrepl       "0.2.12"         :scope "test"]
                 [pandeiro/boot-http            "0.7.1-SNAPSHOT" :scope "test"]
                 [weasel                        "0.7.0"          :scope "test"]
                 [hashobject/boot-s3            "0.1.2-SNAPSHOT" :scope "test"]
                 [crisptrutski/boot-cljs-test   "0.2.2-SNAPSHOT" :scope "test"]
                 [org.martinklepsch/boot-garden "1.3.0-0"]
                 [metosin/ring-http-response  "0.6.5"]
                 [com.stuartsierra/component  "0.3.1"]
                 [org.clojure/clojurescript   "1.7.189"]
                 [org.clojure/core.async      "0.2.374"]
                 [org.clojure/core.match      "0.3.0-alpha4"]
                 [prismatic/schema            "1.0.4"]
                 [prismatic/plumbing          "0.5.2"]
                 [com.rpl/specter             "0.9.2"]
                 [danlentz/clj-uuid           "0.1.6"]
                 [markdown-clj                "0.9.77"]
                 [com.lucasbradstreet/cljs-uuid-utils "1.0.2"]
                 [medley                      "0.7.0"]
                 [env/faker                   "0.4.0"]
                 [compojure                   "1.4.0"]
                 [hiccup                      "1.0.5"]
                 [rum                         "0.6.0"]
                 [sablono                     "0.5.3"]
                 [bidi                        "1.25.0"]
                 [kibu/pushy                  "0.3.6"]
                 [cljsjs/pouchdb              "5.1.0-1"]
                 [cljsjs/react                "0.14.3-0"]
                 [cljsjs/react-dom            "0.14.3-1"]
                 [cljsjs/react-dom-server     "0.14.3-0"]
                 [cljsjs/react-grid-layout    "0.8.5-0"]
                 [cljsjs/fixed-data-table     "0.4.6-0"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[crisptrutski.boot-cljs-test :refer [test-cljs]]
 '[org.martinklepsch.boot-garden :refer [garden]]
 '[pandeiro.boot-http    :refer [serve]]
 '[hashobject.boot-s3    :refer :all])

(deftask css []
  (set-env! :source-paths #(conj % "src/clj"))
  (task-options! garden {:styles-var   'offcourse.styles.index/base
                         :vendors ["webkit" "moz"]
                         :auto-prefix #{:user-select :column-count :column-gap}
                         :output-to    "css/main.css"
                         :pretty-print true})
  (garden))

(deftask build []
  (comp (cljs)
        (css)
        (target)))

(deftask run []
  (comp (serve :handler 'history-handler/app)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask testing []
  (set-env! :source-paths #(conj % "test/cljs"))
  (task-options! test-cljs {:js-env :node})
  identity)

(deftask test-dev []
  (comp (testing)
        (watch)
        (test-cljs)))

 (deftask production []
   (set-env! :source-paths #(conj % "src-prod/cljs"))
   (task-options! target {:dir #{"target/prod"}}
                  cljs   {:optimizations :advanced})
   identity)

 (deftask development []
   (set-env! :source-paths #(conj % "src-dev/cljs" "src-dev/clj"))
   (task-options! target {:dir #{"target/dev"}}
                  cljs   {:optimizations :none
                          :source-map true}
                  reload {:on-jsload 'offcourse.main/reload})
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
