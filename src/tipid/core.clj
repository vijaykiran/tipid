(ns tipid.core
  (:require [compojure.route :as route]
            [compojure.core :as comp]
            [ring.adapter.jetty :as jetty]
            [tipid.api :as api]))

(comp/defroutes app
  (GET "/profile" [] (api/profile)))

(defn start
  ([] (start 7881))
  ([port] (jetty/run-jetty #'app {:port port :join? false})))
