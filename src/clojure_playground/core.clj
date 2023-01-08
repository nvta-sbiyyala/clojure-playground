(ns clojure-playground.core
  (:gen-class))

(defn hello [arg]
  (println "Hello world," arg))

(defn -main
  "I don't do a lot ... yet"
  [& args]
  (hello (first args)))
