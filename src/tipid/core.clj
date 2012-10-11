(ns tipid.core
  (:require [compojure.route :as route]
            [compojure.core :as comp]
            [ring.adapter.jetty :as jetty]))

(comp/defroutes app
  (GET "/" [] "<h1>Hello World</h1>"))

(defn start
  ([] (start 7881))
  ([port] (jetty/run-jetty #'app {:port port :join? false})))
