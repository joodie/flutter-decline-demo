(ns flutter-decline-demo.validations
  (:use decline.core)
  (:require [pretzel.strings :as str]))

(defn required
  [param]
  (validate-val param seq {param ["this is a required field"]}))

(def validate-entry
  (validations
   (required :name)
   (validate-some
    (required :email)
    (validate-val :email str/looks-like-email?
                  {:email ["must contain an @ sign, and a dot in the domain name"]}))
   (validate-some
    (required :phone)
    (validate-val :phone str/looks-like-phone?
                  {:phone ["this doesn't look like a phone number."]}))
   (required :address)))

