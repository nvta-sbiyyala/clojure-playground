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

(def response_body (parse-string ((
                                   client/get "https://api.genderize.io/"
                                   {:accept :json :query-params {"name" "Emily"}}
                                   ;; respond callback
                                   (fn [response] (response))
                                   ;; raise callback
                                   (fn [exception] (println "exception message is: " (.getMessage exception)))
                                   ) :body)))

response_body

