(ns clojure-playground.sequences
  (:gen-class))

(defn titlesize
  [topic]
  (str topic " for the Brave and True"))

(map titlesize ["Hamsters" "Ragnarok"])

(map titlesize '("Empathy" "Decorating"))

(map titlesize #{"Elbows" "Soap Carving"})

(map #(titlesize (first %)) {:uncomfortable-thing "winking"})

(map #(titlesize (second %)) {:uncomfortable-thing "winking"})


{:key1 "value1" :key2 "value2" :key3 "value3"}

;; vector
["shishir" "sachin" 1 2]

;; list
'(1 2 3 34)

;; these are also lists
(defn foo [] (println "bleh"))
(foo)

;; Udemy material
(defn Seq
  []
  (def colors (seq ["red" "green" "blue"]))
  (println colors)

  (println (cons "yellow" colors))
  (println (cons colors "YELLOW"))

  (println (conj colors "RED"))
  (println (conj ["RED" "GREEN" "BLUE"] "yellow"))

  (println (concat colors ["RED" "GREEN" "BLUE"] (seq ["yellow" "BLACK"])))

  (println (distinct (seq [1 2 4 53 11 1 1 1 1])))

  (println (reverse colors))

  (println (first colors))

  (println (rest colors))

  (println (last colors))

  (println (sort (seq [1 43 2 3 11 343])))

  (println (seq ["ZZZZ, AAAA"])) ;; multiple subtleties .. 
  )

(Seq)

(sort > (vals {:foo 5, :bar 2, :baz 10}))
