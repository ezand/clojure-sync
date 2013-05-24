(ns clojure-sync.common
  (:import [java.io FileNotFoundException])
  (:require [clojure.java.io :as io]))

(defn config-file []
  (if-not (= nil (System/getProperty "clojure-sync-props"))
    (io/file (System/getProperty "clojure-sync-props"))
    (do
      (let [file (io/file (io/resource "settings.clj"))]
        (.setReadOnly file) file))))

(defn in?
  "true if seq contains elm"
  [seq elm]
  (some #(= elm %) seq))