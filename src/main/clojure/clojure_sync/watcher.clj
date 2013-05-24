(ns clojure-sync.watcher
  (:use [clojure-config.core]
        [clojure-sync.common])
  (:require [watchdog.core :as watchdog]
            [clojure-sync.picasa :as picasa]
            [clojure-sync.log :as log]
            [clojure.java.io :as io]))

(defn start-watching [keys]
  (if (in? keys :picasa )
    (do
      (doseq [watched-folder (picasa/watched-folders)]
        (watchdog/watch [(io/file (:path watched-folder))] (:events watched-folder) picasa/watch-event-handler))
      (log/info "Started watching Picasa folders"))))

(defn stop-watching [keys]
  (if (in? keys :picasa )
    (do
      (doseq [watched-folder (picasa/watched-folders)]
        (watchdog/unwatch [(io/file (:path watched-folder))] (:events watched-folder)))
      (log/info "Stopped watching Picasa folders"))))
