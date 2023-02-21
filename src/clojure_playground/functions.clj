(ns clojure-playground.functions
  (:gen-class))

(defn -main
  "collection of functions"
  []
  (println "My name is John")
  (println "loving clojure so far")
  (+ 2 5))

#(println "Hello" %)

(defn DataTypes []
  (def a 1)
  (def b 1.25)
  (def c 1.25e-12)
  (def d 0xfbfc)
  (def e nil)
  (def f true)
  (def g "I'm a string")
  (def h 'thanks)
  (println a)
  (println b)
  (println c)
  (println d)
  (println e)
  (println f)
  (println g)
  (println h))

(DataTypes)

(def status true)
(def STATUS false)

(println status)
(println STATUS)

(rem 7 6)


(not= 6 7)

(bit-and 0101 1100)

(bit-or 0101 1100)

(bit-xor 0101 1100)

(bit-not 0101)

(-(/ (+ 2 5) 3) 1)

[1 23 43 43]

'(1 2 3 344)

(quote (1 2 3 344))

(list 123 23432 4 23434 534)

(cons 1 '(2 3 4 5))

(first (list 1 2 4 5))

(last (list 1 2 4 5))

(count (list 1 2 4 5))

(reduce + [1 34 434])

;defs are evaluated only once whereas defns (with or without arguments) are evaluated (executed) every time they are
;called. So if your functions always return the same value, you can change them to defs but not otherwise.
(def increment (fn [x] (+ x 10)))

(defn increment_set
  [x]
  (map increment x))

(map increment [10 100 132])
(increment_set [1 2 3])
