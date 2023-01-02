(ns clojure-playground.sorting)

(defn numbers [n]
  (take n (repeatedly #(rand-int 100))))

;https://eddmann.com/posts/quicksort-in-clojure/
(defn quick-sort [[pivot & coll]]
  (when pivot
    (concat (quick-sort (filter #(< % pivot) coll))
            [pivot]
            (quick-sort (filter #(>= % pivot) coll)))))

(defn -main []
  (quick-sort (numbers 100)))