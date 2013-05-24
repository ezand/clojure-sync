(ns clojure-sync.google
  (:use [clojure-sync.common]
        [clojure-config.core]
        [cloogle-api.common]
        [cloogle-api.picasa]))

(defn config []
  (-> (load-config (config-file)) :google-api ))

(defn- set-status! [status]
  (let [config (assoc (config) :enabled? status)]
    (set-value (config-file) :google-api config)))

(defn enable! [] (set-status! true))

(defn disable! [] (set-status! false))
