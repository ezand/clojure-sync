(ns clojure-sync.watcher
  (:use [clojure-config.core])
  (:require [watchdog.core :as watchdog]
            [clojure-sync.picasa :as picasa]))

(defn start-watching [keys]
  (if (contains? keys :picasa )
    (if (:enabled? (picasa/picasa-config))
      (watchdog/watch (map :path (picasa/watched-folders)) (map :events (picasa/watched-folders)) picasa/watch-event-handler))))

(defn stop-watching [keys]
  (if (contains? keys :picasa )
    (if (:enabled? (picasa/picasa-config))
      (watchdog/unwatch (map :path (picasa/watched-folders)) (map :events (picasa/watched-folders)) picasa/watch-event-handler))))
