(defproject clojure-sync "0.1.0-SNAPSHOT"
  :description "Synchronize your local files with various targets"
  :url "http://github.com/ezand/clojure-sync"
  :java-source-paths ["src/main/java"]
  :source-paths ["src/main/clojure"]
  :resource-paths ["src/main/resources"]
  :test-paths ["src/test/clojure"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.json "0.2.2"]
                 [me.raynes/fs "1.4.2"]
                 [org.clojure/tools.logging "0.2.6"]
                 [ch.qos.logback/logback-classic "1.0.9"]
                 [org.clojars.ezand/clojure-config "1.0"]
                 [org.clojars.ezand/cloogle-api "1.0.1" :exclusions [log4j/log4j org.slf4j/slf4j-log4j12]]
                 [watchdog "1.0"]]
  :main clojure-sync.core)
