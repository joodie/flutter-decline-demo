(ns flutter-decline-demo.routes
  (:use compojure.core
        [flutter-decline-demo views fields db]
        [compojure.route :only [files]]))

(defroutes my-routes
  (GET "/"
       _
       (view-list))
  (GET "/create"
       _
       (view-form (field-fn {} {})))
  (POST "/commit"
        {:keys [params]}
        (if-let [errors (validate-entry params)]
          (view-form (field-fn params errors))
          (view-form (field-fn params nil))))
  (POST "/commit/:old-name"
        {:keys [params]}

        )
  (files "/"))

