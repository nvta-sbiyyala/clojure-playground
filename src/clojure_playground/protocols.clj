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

;; https://clojuredocs.org/clojure.core/extend-protocol
(defprotocol XmlNode
  (as-xml [this]))

(defrecord User [^Integer id ^String name ^java.util.Date dob])
(defn create-user [id name dob] (->User id name dob))

;; Protocols can be extended to existing types and user defined types
(extend-protocol XmlNode
  Integer
  (as-xml [this] (str this))
  Long
  (as-xml [this] (int this))
  String
  (as-xml [this] (identity this))
  java.util.Date
  (as-xml [this] (-> (java.text.SimpleDateFormat. "yyyy-MM-dd HH:mm:ss")
                     (.format this)))
  User
  (as-xml [this] (str "<user>"
                      "<id>" (as-xml (:id this)) "</id>"
                      "<name>" (as-xml (:name this)) "</name>"
                      "<dob>" (as-xml (:dob this)) "</dob>"
                      "</user>")))

(deftest test-as-xml-string
  (let [result (as-xml "test")]
    (is (= "test" result))))

(deftest test-as-xml-long
  (let [result (as-xml 10)]
    (is (= 10 result))))

(deftest test-as-xml-int
  (let [result (as-xml (int 10))]
    (is (= "10" result))))

(deftest test-as-xml-date
  (let [date (java.util.Date. 0) result (as-xml date)]
    (is (= "1969-12-31 19:00:00" result))))

(deftest test-as-xml-user
  (let []
    (is (= "1969-12-31 19:00:00" result))))
