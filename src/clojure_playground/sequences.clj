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


