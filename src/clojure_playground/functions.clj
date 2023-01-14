(ns clojure-playground.functions
  (:gen-class))

(defn -main
  "collection of functions"
  []
  (println "My name is John")
  (println "loving clojure so far")
  (+ 2 5))

#(println "Hello" %)

;defs are evaluated only once whereas defns (with or without arguments) are evaluated (executed) every time they are
; called. So if your functions always return the same value, you can change them to defs but not otherwise.
(def increment (fn [x] (+ x 1)))

(defn increment_set
  [x]
  (map increment x))

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
  (println h)

  )
(DataTypes)
