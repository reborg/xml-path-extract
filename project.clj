(defproject xml-path-extract "0.1.0-SNAPSHOT"
  :description ""
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.cli "0.2.2"]]
  :plugins []
  :main xml-path-extract.core
  :uberjar-name "xpe.jar"
  :java-source-paths ["java"]
  :profiles {:dev {:dependencies []}})
