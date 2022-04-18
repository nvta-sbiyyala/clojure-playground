(defproject clojure-playground "0.1.0-SNAPSHOT"
  :description "Shishir Biyyala's Clojure playground"
  :url "https://github.com/nvta-sbiyyala/clojure-playground"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 ;; in collection under :dependencies key
                 [com.datomic/datomic-pro "1.0.6397" :exclusions [joda-time org.clojure/clojure]]]
  :repl-options {:init-ns clojure-playground.core}
  :main clojure-playground.core)
