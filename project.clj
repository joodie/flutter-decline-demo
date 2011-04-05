(defproject flutter-decline-demo "1.1.0"
  :main flutter-decline-demo.core
  :description "Demo compojure application with flutter and clj-decline"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [clj-decline "0.0.5"]
                 [flutter "0.0.2"]
                 [compojure "0.5.3"]
                 [hiccup "0.3.2"]
                 [ring/ring-jetty-adapter "0.3.1"]
                 [pretzel "0.2.0"]]
  :dev-dependencies [[ring-mock "0.1.1"]
                     [lein-run "1.0.0"]])
