(ns flutter-decline-demo.fields
  (:use [decline core]
        [flutter html4 labels shortcuts params]))

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

(defn required
  [param]
  (validate-val param seq {param ["this is a required field"]}))

(defn valid-phone?
  [s]
  (re-matches #"^[\d\s-]*$" s))

(def validate-entry
  (validations
   (required :name)
   (required :email)
   (required :phone)
   (validate-val :phone valid-phone?
                 {:phone ["may only contain numbers, spaces and dashes"]})
   (required :address)))

(defn field-fn
  [params errors]
  (-> html4-fields
      (wrap-labels (make-label errors))
      wrap-shortcuts
      (wrap-params params)))
