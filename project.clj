(defproject parens-of-the-dead "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [http-kit "2.1.18"]
                 [com.stuartsierra/component "0.2.3"]
                 [reloaded.repl "0.1.0"]
                 [compojure "1.4.0"]]
  :main ^:skip-aot parens-of-the-dead.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev     {:plugins [[lein-cljsbuild "1.1.1"]
                                 [lein-figwheel "0.5.0-6"]]
                       :source-paths ["src"]
                       :cljsbuild {:builds [{:source-paths ["src"]
                                             :figwheel true
                                             :compiler {    ;:output-to "target/classes/public/app.js"
                                                        ;:output-dir "target/classes/public/out"
                                                        :output-to "resources/public/js/app.js"
                                                        :output-dir "resources/public/js/out"
                                                        :optimizations :none
                                                        :recompile-dependents true
                                                        :source-map true}}]}}})
