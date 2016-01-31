(ns parens-of-the-dead.core
  (:require [org.httpkit.server :refer [run-server]]
            [com.stuartsierra.component :as c]
            [parens-of-the-dead.web :refer [app]])
  (:gen-class))

#_(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello from undead"})


(defn- start-server [handler port]
  (let [server (run-server #' app {:port port})]
    (println "started server on " port)
    server))

(defn- stop-server [server]
  (when server
    (server)))
;; server has function that stops itself

(defrecord ParensOfTheDead []
  c/Lifecycle
  (start [this]
    (assoc this :server (start-server app 9009)))
  (stop [this]
    (stop-server (:server this))
    (dissoc this :server)))

(defn create-system []
  (ParensOfTheDead.))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (.start (create-system)))

