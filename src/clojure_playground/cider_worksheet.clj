(ns clojure-playground.cider_worksheet
  (:gen-class)
  (:require [clj-http.client :as client])
  (:require [cheshire.core :refer :all])
  )

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

(defn add [x] (+ x 100))

(map add [1 2 3])

{:key1 "val1" :key2 "val2", :key3 "val3"}

;; http stuff
;; (client/get "https://api.publicapis.org/entries")

;; building block-1
;; (defn http_function [url query_params] (
;;                            client/get url
;;                            {:accept :json :query-params query_params}
;;                            ;; respond callback
;;                            (fn [response] (response))
;;                            ;; raise callback
;;                            (fn [exception] (println "exception message is: " (.getMessage exception)))
;;                            ))

;; building block-2
;; (def response_body (parse-string ((http_function "https://api.genderize.io/" {"name" "Sasha"}) :body)))

(def response_body
  (parse-string ((
                  client/get "https://api.genderize.io/"
                  {:accept :json :query-params {"name" "Emily"}}
                  ;; respond callback
                  (fn [response] (response))
                  ;; raise callback
                  (fn [exception] (println "exception message is: " (.getMessage exception)))
                  ) :body)))

response_body

(first [:seltzer :water])

;; Polymorphism -- The main way we achieve abstraction in Clojure is by associating an operation name with more than one algorithm. This technique is called "polymorphism"
;;;; Multimethods
(defmulti full-moon-behavior (fn [were-creature] (:were-type were-creature)))
(defmethod full-moon-behavior :wolf
  [were-creature]
  (str (:name were-creature) " will howl and murder"))

(defmethod full-moon-behavior :simmons
  [were-creature]
  (str (:name were-creature) " will encourage people and sweat to the oldies"))

(full-moon-behavior {:were-type :wolf
                     :name "Rachel from next door"})
(full-moon-behavior {:were-type :simmons
                     :name "Randy the baker"})

(defmethod full-moon-behavior nil
  [were-creature]
  (str (:name were-creature) " will stay at home and eat ice cream"))

(full-moon-behavior {:were-type nil
                     :name "Rob the engineer"})

(defmethod full-moon-behavior :default
  [were-creature]
  (str (:name were-creature) " will stay up all night fantasy footballing"))

(full-moon-behavior {:were-type :office-worker
                     :name "Jimmy from sales"})

;; protocols; protocols are optimized for type dispatch. They're more efficient than multimethods, and Clojure makes it easy for you to succintly specify protocol implementations.
;; A multimethod is just one polymorphic operation, whereas a protocol is a collection of one or more polymorphic operations. Protocol operations are called methods, just like
;; multimethod operations

;;;; defprotocol
(defprotocol Psychodynamics
  "Plumb the inner depths of your data types"
  (thoughts [x] "The data type's innermost thoughts")
  (feelings-about [x] [x y] "Feelings about self or other"))


