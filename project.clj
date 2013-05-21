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
                 [clj-config "0.2.0"]
                 [org.clojars.ezand/cloogle-api "1.0.0"]]
  :main clojure-sync.core)
