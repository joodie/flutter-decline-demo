(ns flutter-decline-demo.fields
  (:use [flutter html4 labels shortcuts params]))

(def labels
  {:name "Name"
   :email "Email address"
   :phone "Phone number"
   :address "Home address"})

(defn make-label
  "Combine errors into label for fields"
  [errors]
  (fn [name]
    (if-let [errs (errors name)]
      [:span (labels name) " ! " [:strong.error (interpose " - " errs)]]
      (labels name))))

(defn field-fn
  [params errors]
  (-> html4-fields
      (wrap-labels (make-label errors))
      wrap-shortcuts
      (wrap-params params)))
