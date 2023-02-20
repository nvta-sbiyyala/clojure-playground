(ns clojure-playground.cider_worksheet
  (:gen-class))

(defn add [x] (+ x 100))

(defn greet [name] (str "Hello, " name))

(greet "Shishir")

(defn hello
  ([]
   (println "Debugging statements...")
   "Hello Shishir")
  ([name]
   (str "Hello, " name)))

(hello "Tendulkar")

(hello)

(println hello)

(str 1)

(def drinks ["Coke" "Fanta"])

(defn can-drink? [age]
  (let [a "Common Drink"]
  (if (>= age 18)
    (conj drinks "Beer" a)
    (conj drinks "Cider" a))))

drinks

(can-drink? 17)

(can-drink? 19)

drinks
