(ns flutter-decline-demo.core
  ^{:doc "Oh great, another CRUD demo"
    :autor "Joost Diepenmaat"}
  (:use [ring.adapter.jetty]
        flutter-decline-demo.routes
        [ring.middleware params keyword-params]))

(def handler
  (-> #'my-routes
      wrap-keyword-params
      wrap-params))

(def server (atom nil))

(defn run-demo
  ([]
     (run-demo 8080))
  ([port]
     (swap! server #(run-demo % port)))
  ([server port]
     (when-not server
       (run-jetty #'handler {:port port :join? false}))))

(defn stop-demo
  ([]
     (swap! server #(stop-demo %)))
  ([server]
     (when server
       (.stop server)
       nil)))

(defn -main
  ([]
     (run-demo 8080))
  ([port]
     (run-demo port)))