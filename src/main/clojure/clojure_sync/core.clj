(ns clojure-sync.core
  (:gen-class )
  (:import [java.io FileNotFoundException])
  (:require [clojure.java.io :as io]
            [clojure-config.core :as c]
            [clojure-sync.log :as log]
            [clojure-sync.common :as common]
            [clojure-sync.google :as google]
            [clojure-sync.picasa :as picasa]
            [clojure-sync.watcher :as watcher]
            [cloogle-api.common :as cloogle-common]
            [cloogle-api.picasa :as cloogle-picasa]))

(defn run []
  (if (:enabled? (google/config))
    (do
      (cloogle-common/load-properties (cloogle-common/load-properties (select-keys (google/config) [:client_id :client_secret ])))
      (if (:enabled? (picasa/config))
        (do
          (cloogle-picasa/auth "Clojure Sync")
          (watcher/start-watching [:picasa ]))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (run))

