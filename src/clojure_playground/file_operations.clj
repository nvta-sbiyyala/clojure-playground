(ns clojure-playground.file_operations
  (:gen-class))

;; reading entire file into memory
(slurp "README.org")

;; reading line by line
(use 'clojure.java.io)
(with-open [rdr (reader "README.org")]
  (doseq [line (line-seq rdr)]
    (println line)))

;; write to file
(with-open [wrtr (writer "README.org" :append true)]
  (.write wrtr "\nappend some text, Clojure\n"))

;; using spit
(spit "README.org" "Spit some text and append to the file\n" :append true)
