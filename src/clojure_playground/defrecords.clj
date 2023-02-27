(import java.net.FileNameMap)

;; Define a record named Thing with a single field a.  Implement
;; FileNameMap interface and provide an implementation for the single
;; method:  String getContentTypeFor(String fileName)
(defrecord Thing [a]
  FileNameMap
  (getContentTypeFor [this fileName] (str a "-" fileName)))

(def thing (Thing. "foo"))

(instance? FileNameMap thing)

(map #(println %) (.getInterfaces Thing))
