(ns clojure-sync.core
  (:gen-class )
  (:import [java.io FileNotFoundException])
  (:require [clojure.java.io :as io]
            [clojure-config.core :as c]
            [clojure-sync.log :as log]))

(defn config-file []
  (if-not (= nil (System/getProperty "clojure-sync-props"))
    (io/file (System/getProperty "clojure-sync-props"))
    (do
      (let [file (io/file (io/resource "settings.clj"))]
        (.setReadOnly file) file))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]

  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false)))

