(ns flutter-decline-demo.views
  (:use [hiccup core page-helpers
         [form-helpers :only [form-to]]]
        flutter-decline-demo.db))

(def site-name
  "Flutter-Decline demo")

(defn view-wrapper
  "Set up layout for views"
  [title & body]
  (html
   [:html
    [:head
     [:title site-name " ~ " (escape-html title)]
     (include-css "/style.css")]
    [:body
     [:h1 (escape-html title)]
     body]]))

(defn view-list
  []
  (view-wrapper
   "All entries"
   [:ul (map #(vector :li
                      (link-to (str "/edit/" (:id %))
                               (escape-html (:name %)))) (list-entries))]
   (link-to "/create" "Make a new entry")))

(defn view-form
  [field]
  (view-wrapper
   "Create / Edit"
   [:h2 "Please enter the following information"]
   (form-to [:post "/commit"]
            (field :hidden :id)
            (field :text :name)
            (field :text :email)
            (field :text :phone)
            (field :text-area :address)
            (field :submit nil :action nil :commit)
            (field :submit nil :action nil :revert)
            (field :submit nil :action nil :delete))))
