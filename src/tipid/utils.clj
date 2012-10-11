(ns tipid.utils
  (:require [cheshire.core :as json]))

(defn success
  "Send success response with correct headers & m as body"
  [m]
  {
   :status 200
   :headers {"Content-Type" "application/vnd.tent.v0+json"}
   :body (json/encode m)})
