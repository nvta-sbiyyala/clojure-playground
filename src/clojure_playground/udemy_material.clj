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

