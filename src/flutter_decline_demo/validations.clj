(ns flutter-decline-demo.validations
  (:use decline.core))

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

