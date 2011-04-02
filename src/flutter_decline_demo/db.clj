(ns flutter-decline-demo.db)

(def db (atom {}))

(defn list-entries
  []
  (sort-by :name @db))

(defn get-entry
  [name]
  (or (@db name)
      {}))
