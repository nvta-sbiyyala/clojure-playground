(defn titlesize
  [topic]
  (str topic " for the Brave and True"))

(map titlesize ["Hamsters" "Ragnarok"])

(map titlesize '("Empathy" "Decorating"))

(map titlesize #{"Elbows" "Soap Carving"})

(map #(titlesize (first %)) {:uncomfortable-thing "winking"})

(map #(titlesize (second %)) {:uncomfortable-thing "winking"})
