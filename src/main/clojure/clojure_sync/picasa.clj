(ns clojure-sync.picasa
  (:use [clojure-sync.common]
        [clojure-config.core]
        [cloogle-api.picasa])
  (:require [clojure-sync.log :as log]
            [clojure-sync.google :as google]))

(defn config []
  (-> (load-config (config-file)) :picasa ))

(defn- set-status! [status]
  (let [config (assoc (config) :enabled? status)]
    (set-value (config-file) :picasa config)))

(defn enable! []
  (if (:enabled? (google/config))
    (do
      (auth "Clojure Sync")
      (set-status! true))
    (do
      (set-status! false)
      (log/warn "Can not enable Picasa when Google API is disabled."))))

(defn disable! [] (set-status! false))

(defn watched-folders []
  (-> (config) :watched-folders ))

(defn watch-event-handler [watch-event]
  (if (:enabled? (config))
    (do
      (case (:event watch-event)
        "ENTRY_CREATE" (prn (str "Created: " (str (:file watch-event))))
        "ENTRY_MODIFY" (prn (str "Modified: " (str (:file watch-event))))))))
