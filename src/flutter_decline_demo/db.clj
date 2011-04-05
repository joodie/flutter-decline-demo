(ns flutter-decline-demo.db
  (:import java.util.UUID))

(defonce db (atom {}))

(defn list-entries
  []
  (sort-by :name (vals @db)))

(defn get-entry
  [id]
  (when-not (re-matches #"^[\da-z-]*$" id)
    (throw (Exception. (str "Invalid id: " id))))
  (@db id))

(defn add-entry
  [db obj]
  (let [id (str (UUID/randomUUID))]
    (assoc db id (assoc obj :id id))))

(defn update-entry
  [db obj]
  (if (seq (:id obj))
    (assoc db (:id obj) obj)
    (add-entry db obj)))

