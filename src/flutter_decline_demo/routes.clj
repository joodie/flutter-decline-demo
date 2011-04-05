(ns flutter-decline-demo.routes
  (:use compojure.core
        [flutter-decline-demo views fields validations db]
        [compojure.route :only [files]]
        [ring.util.response :only [redirect]]))

(defroutes my-routes
  (GET "/"
       _
       (view-list))
  (GET "/create"
       _
       (view-form (field-fn {} {})))
  (GET "/edit/:id"
       [id]
       (view-form (field-fn (get-entry id) {})))
  (POST "/commit"
        {:keys [params]}

        ;; switch action based on which submit button
        ;; was pressed
        (case (:action params)
              
              "revert"
              (view-form (field-fn (get-entry (:id params)) {}))

              "delete"
              (do (swap! db dissoc (:id params))
                  (redirect "/"))

              ;; default action (commit/update)
              (if-let [errors (validate-entry params)]
                (view-form (field-fn params errors))
                (do (swap! db update-entry params)
                    (redirect "/")))))
  (files "/"))

