(ns clojure-sync.core
  (:gen-class )
  (:require [clj-config.core :as config]
            [me.raynes.fs :as fs]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false)))

(prn (config/read-config (fs/file "src/main/resources/settings.clj")))

(config/set-key (fs/file "src/main/resources/settings.clj") :x 666)
;(config/set-key (fs/file "src/main/resources/settings.clj") :foo "bar")
;(prn (config/read-config (fs/file "src/main/resources/settings.clj")))

;(config/write-config (fs/file "src/main/resources/settings.clj") {:sna "fu"})
