(ns clojure-sync.google
  (:use [clojure-sync.core]
        [clojure-config.core]
        [cloogle-api.common]
        [cloogle-api.picasa]))

(defn google-config []
  (-> (load-config (config-file)) :google-api ))

(defn- set-status! [status]
  (let [config (assoc (google-config) :enabled? status)]
    (set-value (config-file) :google-api config)))

(defn enable! []
  (load-properties (select-keys (google-config) [:client_id :client_secret ]))
  (set-status! true))

(defn disable! [] (set-status! false))
