(require '[datomic.api :as d]
         '[datomic.samples.repl :as repl])
(def uri "datomic:free://localhost:4334/mbrainz-1968-1973")
(def conn (d/connect uri))
(def db (d/db conn))
(set! *print-length* 100)
;; WIP -- https://github.com/Datomic/day-of-datomic/blob/master/tutorial/query.clj
