(ns flutter-decline-demo.core
  (:use [ring.adapter.jetty]
        flutter-decline-demo.routes
        [ring.middleware params keyword-params]))

(def handler
  (-> my-routes
      wrap-keyword-params
      wrap-params))

(def server (atom nil))

(defn run-demo
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


