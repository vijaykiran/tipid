(ns tipid.core
  (:require [compojure.route :as route]
            [compojure.core :as comp]
            [ring.adapter.jetty :as jetty]
            [tipid.api :as api]))

(comp/defroutes routes
  (comp/GET "/profile" [] (api/profile))
  (comp/POST "/followers" {body :body} (api/add-follower body))
  (comp/DELETE "/followers" {body :body} (api/delete-follower body)))

(defn start
  ([] (start 7881))
  ([port] (jetty/run-jetty #'app {:port port :join? false})))


(defn -main [args]
  (println (System/getenv "PORT"))
  (start (Integer/valueOf (System/getenv "PORT"))))
