(ns protocols
  (:require [clojure.test :refer :all]))

(defprotocol MyProtocol
  (foo [this x]))

(deftype MyType []
  MyProtocol
  (foo [this x] (+ x 1)))

(deftype MyOtherType []
  MyProtocol
  (foo [this x] (- x 1)))

(extend-protocol MyProtocol
  nil
  (foo [this x] (+ x 100)))

(deftest test-my-protocol
  (let [object1 (->MyType)
        object2 (->MyOtherType)]
    (is (= 3 (foo object1 2)))
    (is (= 1 (foo object2 2)))))
