(set-env!
 :source-paths    #{"sass" "src/cljs" "src/cljc"}
 :resource-paths  #{"resources"}
 :dependencies '[[adzerk/boot-cljs           "1.7.170-3"   :scope "test"]
                 [adzerk/boot-cljs-repl      "0.2.0"       :scope "test"]
                 [adzerk/boot-reload         "0.4.1"       :scope "test"]
                 [pandeiro/boot-http         "0.6.3"       :scope "test"]
                 [mathias/boot-sassc         "0.1.1"      :scope "test"]
                 [org.clojure/clojurescript  "1.7.170"]
                 [com.stuartsierra/component "0.3.1"]
                 [cljsjs/react               "0.14.3-0"]
                 [cljsjs/react-dom           "0.14.3-1"]
                 [cljsjs/react-dom-server    "0.14.3-0"]
                 [org.clojure/core.async     "0.2.374"]
                 [org.clojure/core.match     "0.3.0-alpha4"]
                 [cljsjs/react-grid-layout   "0.8.5-0"]
                 [medley                     "0.7.0"]
                 [cljsjs/pouchdb             "3.5.0-1"]
                 [env/faker                  "0.4.0"]
                 [rum                        "0.6.0"]
                 [sablono                    "0.5.3"]])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]]
 '[mathias.boot-sassc    :refer [sass]])

(deftask build []
  (comp (cljs)
        (sass :output-dir "css")))

(deftask run []
  (comp (serve)
        (watch)
        (cljs-repl)
        (reload)
        (build)))

(deftask production []
  (set-env! :source-paths #(conj % "src-prod/cljs"))
  (task-options! cljs   {:optimizations :advanced}
                 sass   {:output-style "compressed"})
  identity)

(deftask development []
  (set-env! :source-paths #(conj % "src-dev/cljs"))
  (task-options! cljs   {:optimizations :none :source-map true}
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
