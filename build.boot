(comment "check cuerdas and specter for api updates")

(set-env!
 :source-paths    #{"src/cljs" "src/clj"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs              "1.7.228-1"      :scope "test"]
                 [adzerk/boot-cljs-repl         "0.3.3"          :scope "test"]
                 [adzerk/boot-reload            "0.4.12"         :scope "test"]
                 [ring/ring-devel               "1.6.0-beta5"    :scope "test"]
                 [com.cemerick/piggieback       "0.2.2-SNAPSHOT" :scope "test"]
                 [org.clojure/tools.nrepl       "0.2.12"         :scope "test"]
                 [pandeiro/boot-http            "0.7.3"          :scope "test"]
                 [weasel                        "0.7.0"          :scope "test"]
                 [hashobject/boot-s3            "0.1.2-SNAPSHOT" :scope "test"]
                 [crisptrutski/boot-cljs-test   "0.3.0-SNAPSHOT" :scope "test"]
                 [binaryage/devtools            "0.8.1"          :scope "test"]
                 [binaryage/dirac               "0.6.3"          :scope "test"]
                 [powerlaces/boot-cljs-devtools "0.1.1"          :scope "test"]
                 [boot-codox                    "0.9.6"          :scope "test"]
                 [org.martinklepsch/boot-garden "1.3.2-0"]
                 [metosin/ring-http-response    "0.8.0"]
                 [com.stuartsierra/component    "0.3.1"]
                 [org.clojure/clojurescript     "1.9.225"]
                 [org.clojure/core.async        "0.2.385"]
                 [org.clojure/core.match        "0.3.0-alpha4"]
                 [prismatic/plumbing            "0.5.3"]
                 [com.rpl/specter               "0.12.0"]
                 [markdown-clj                  "0.9.89"]
                 [cljs-ajax                     "0.5.8"]
                 [medley                        "0.8.3"]
                 [env/faker                     "0.4.0"]
                 [compojure                     "1.6.0-beta1"]
                 [hiccup                        "1.0.5"]
                 [rum                           "0.10.6"]
                 [sablono                       "0.7.4"]
                 [bidi                          "2.0.9"]
                 [kibu/pushy                    "0.3.6"]
                 [cljsjs/auth0                  "6.3.0-0"]
                 [cljsjs/js-yaml                "3.3.1-0"]
                 [cljsjs/auth0-lock             "9.2.1-0"]
                 [cljsjs/react                  "15.3.1-0"]
                 [cljsjs/react-dom              "15.3.1-0"]
                 [cljsjs/react-dom-server       "15.3.1-0"]
                 [funcool/cuerdas               "0.8.0"]
                 [offcourse/styles              "0.1.8-SNAPSHOT"]
                 [offcourse/shared              "0.1.0-SNAPSHOT"]])

(require
 '[adzerk.boot-cljs              :refer [cljs]]
 '[adzerk.boot-cljs-repl         :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload            :refer [reload]]
 '[powerlaces.boot-cljs-devtools :refer [cljs-devtools]]
 '[org.martinklepsch.boot-garden :refer [garden]]
 '[crisptrutski.boot-cljs-test   :refer [exit! test-cljs]]
 '[pandeiro.boot-http            :refer [serve]]
 '[hashobject.boot-s3            :refer :all])

(deftask testing []
  (merge-env! :resource-paths #{"test"})
  identity)

(deftask auto-test []
  (comp (testing)
        (watch)
        (speak)
        (test-cljs)))

(deftask css []
  (set-env! :source-paths #(conj % "src/clj"))
  (task-options! garden {:styles-var   'offcourse.styles.index/base
                         :vendors ["webkit" "moz"]
                         :auto-prefix #{:user-select :column-count :column-gap}
                         :output-to    "css/main.css"
                         :pretty-print true})
  (garden))

(deftask dev []
  (set-env! :source-paths #(conj % "src-dev/cljs" "src-dev/clj"))
  (task-options! target {:dir #{"dev/"}}
                 serve {:handler 'history-handler/app}
                 reload {:on-jsload 'offcourse.main/reload}
                 cljs {:source-map true
                       :optimizations :none})
  (comp (serve)
        (watch)
        (speak)
        (reload)
        (cljs-repl)
        (cljs-devtools)
        (cljs)
        (css)
        (target)))

(deftask test []
  (comp (testing)
        (test-cljs)
        (exit!)))

(deftask build []
  (set-env! :source-paths #(conj % "src-prod/cljs"))
  (task-options! target {:dir #{"dist/"}}
                 cljs {:optimizations :advanced})
  (comp (cljs)
        (css)
        (target)))

(deftask deploying []
  (set-env! :target-path "dist/")
  (task-options! s3-sync {:source ""
                          :access-key (get-sys-env "AWS_ACCESS_OFFCOURSE_KEY" :required)
                          :secret-key (get-sys-env "AWS_SECRET_OFFCOURSE_KEY" :Required)})
  identity)

(deftask deploy-prod []
  (task-options! s3-sync #(assoc % :bucket "offcourse-frontend-production"))
  (comp (deploying)
        (build)
        (s3-sync)))


(deftask deploy-staging []
  (task-options! s3-sync #(assoc % :bucket "offcourse-frontend-staging"))
  (comp (deploying)
        (build)
        (s3-sync)))


(deftask deploy-dev-design []
  (task-options! s3-sync #(assoc % :bucket "offcourse-frontend-dev-design"))
  (comp (deploying)
        (build)
        (s3-sync)))