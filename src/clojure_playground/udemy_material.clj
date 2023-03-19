(ns clojure-playground.udemy_material
  (:gen-class))

(defn pet_to_human_age
  "Returns the age of a pet in human years"
  [x]
  (def pet_store {'dog 7, 'cat 5, 'goldfish 10})
  (get pet_store x -1))

(defn age
  "Returns age of a pet"
  [pet_name pet_type pet_age]
  (def ratio (pet_to_human_age pet_type))
  (str pet_name " is " (* ratio pet_age) " years old in human years"))

(age "Simba" 'dog 1)
(age "Catty" 'cat 10)
(age "Goldy" 'goldfish 100)
(age "Hydra" 'hydra 14)

;; Conditionals
(defn if_conditional
  [input]
  (println "\n a simple function demonstrating if conditionals in Clojure..")
  (if (= input 5)
    (println "Input is 5")
    (println "Input is not 5")))

(if_conditional 10)

(defn if_do_conditional
  [input]
  (println "\n a simple function demonstrating if do conditionals in Clojure..")
  (if (= input 5)
    (do (println "Equal first statement")
        (println "Equal second statement"))
    (do (println "NOT Equal first statement")
        (println "NOT Equal second statement"))
    ))

(if_do_conditional 5)

(defn cond_nested_if
  []
  (println "\n nested if example")
  (if (and (= 5 5) (or (= 2 2) (not true)))
    (println "True")
    (println "False")
    ))

(cond_nested_if)

(defn cond_case
  [pet]
  (println "Cond Case")
  (case pet
    "cat" (println "I have a CAT")
    "dog" (println "I have a DOG")
     ))

(cond_case "cat")

(defn cond-cond
  [amount]
  (cond
        (<= amount 2) (println "FEW")
        (<= amount 10) (println "SEVERAL")
        (<= amount 100) (println "MANY")
        :else (println "LOADS")
        ))

(cond-cond 1)

;; Loops
(defn Loop
  [limit]
  (println "\nLoop:")
  (loop [x 0]
    (when (< x limit)
      (println x)
      (recur (inc x)))
    ))

(Loop 100)

(defn do-times
  [limit]
  (println "\n" "DoTimes:")
  (dotimes [x limit]
    (println x))
  )

(do-times 10)

;; Atoms // mutable // thread-safe

(defn while-do
  [count]
  (println "\n" "While Do:")
  (def x (atom 0))
  (while (< @x count)
    (do
      (println @x)
      (swap! x inc)))
  )

(while-do 10)

(defn do-seq
  [seq multiply_with]
  (println "\n Do Seq")
  (doseq [x seq]
    (println (inc (* x multiply_with))))
  )

(do-seq [1 2 3 4 5 6] 101)

(defn atoms
  []
  (def amount (atom 100))
  (println @amount)

  (swap! amount inc)
  (println @amount)

  (reset! amount 110)
  (println @amount)

  (compare-and-set! amount 110 120)
  (println @amount)

  (compare-and-set! amount 110 150)
  (println @amount)

  )
(atoms)

;; structMaps

(defn pets
  []
  (defstruct pet :PetType :PetName)
  (def my-pet (struct pet "dog" "Fido"))
  (println my-pet)

  (def my-other-pet (struct-map pet :PetName "Goofy" :PetType "Cat"))
  (println my-other-pet)
  (println (:PetType my-other-pet))

  (def my-new-pet (assoc my-pet :PetName "MAX"))
  (println my-new-pet)

  (def my-pet-with-additional-attribute (assoc my-other-pet :PetAge 100))
  (println my-pet-with-additional-attribute)
  )

(pets)

;; Destructuring

(defn destruct
  []
  (def my-vector [1 3 4 5])
  (let [[a b c] my-vector] (println a b c))
  (let [[a b & rest] my-vector] (println a b rest))

  (def my-map {'name "John" 'lastname "Smith"})
  (let [{a 'name b 'lastname c 'noname} my-map] (println a b c))
  )

(destruct)

;; Exception handling

(defn ex-handling
  [x]
  (try
    (inc x)
    (catch ClassCastException e (println "Caught Exception:" (.getMessage e)))
    (catch Exception e (println "Caught generic exception"))
    (finally (println "cleanup and move on")))
  )

(ex-handling 1)
(ex-handling "shishir")

;; coding challenge

(def dealership {'bmw 60000})

(:bmw dealership)

(defn is-code-valid
  [code]
  (defstruct coupon :Name :Discount)
  (def valid-coupon (struct coupon "20Percent" 0.8))
  (if (= (:Name valid-coupon) code)
  true
  false
  ))

(is-code-valid "20Percent")

(defn get-car-prices
  [budget code]
  (def cars {"bmw" 60000, "ferrari" 10000, "fiat" 20000})
  (if (is-code-valid code)
    (do
      (println "The code is valid")
      (def discount (:Discount valid-coupon))
      (doseq [car cars]
        (def car-type (first car))
        (def price (last car))
        (def price-discount (* price discount))
        (if (<= price-discount budget)
          (println "The " car-type " costs " price-discount))
        )
      )
    (do
      (println "The code is invalid")
      (doseq [car cars]
        (def car-type (first car))
        (def price (last car))
        (if (<= price budget)
          (println "The " car-type " costs " price))
        )
      )
    )
  )

(get-car-prices 50000 "20Percents")
