(ns clojure-sync.picasa
  (:use [clojure-sync.core]
        [clojure-config.core]
        [cloogle-api.picasa])
  (:require [clojure-sync.log :as log]))

(defn picasa-config []
  (-> (load-config (config-file)) :picasa ))

(defn- set-status! [status]
  (let [config (assoc (picasa-config) :enabled? status)]
    (set-value (config-file) :picasa config)))

(defn enable! []
  (if (-> (get-value (config-file) :google ) :enabled? )
    (do
      (auth "Clojure Sync")
      (set-status! true))
    (do
      (set-status! false)
      (log/warn "Can not enable Picasa when Google API is disabled."))))

(defn disable! [] (set-status! false))

(defn watched-folders []
  (-> (picasa-config) :watched-folders ))

(defn watch-event-handler [watch-event]
  (log/info watch-event))