(ns tipid.api
  (:use [tipid.utils]))

(def user-info
  {:name "tipid"
   :avatar_url ""
   :birthdate "2012-10-12"
   :location "The Internetz"
   :bio "Vijay's tent.io Clojure implementation!"
   :permissions {:public true}})
(def licenses  ["http://creativecommons.org/licenses/by/3.0/"])
(def servers ["https://vktent.heroku.com"])
(def permissions {:public true})

(defn profile
  "Send Profile Response"
  []
  (success {"https://tent.io/types/info/basic/v0.1.0" user-info
            "https://tent.io/types/info/core/v0.1.0" {
                                                      :licenses licenses
                                                      :entity "http://vijaykiran.com"
                                                      :servers servers
                                                      :permissions permissions}}))

(defn add-follower
  "add follower"
  [body]
  (println (slurp body))
  (success {}))

(defn delete-follower
  "Delete follower"
  [id body headers]
  (println (slurp body))
  (println headers)
  (println id)
  (success {}))
