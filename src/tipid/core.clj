(ns tipid.core
  (:require [compojure.route :as route]
            [compojure.core :as comp]
            [ring.adapter.jetty :as jetty]
            [tipid.api :as api]))

(comp/defroutes app
  (comp/GET "/profile" [] (api/profile))
  (comp/POST "/followers" {body :body headers :headers} (api/add-follower body))
  (comp/DELETE "/followers/:id" {body :body headers :headers id :id} (api/delete-follower)))

(defn start
  ([] (start 7881))
  ([port] (jetty/run-jetty #'app {:port port :join? false})))


(defn -main [args]
  (println (System/getenv "PORT"))
  (start (Integer/valueOf (System/getenv "PORT"))))
