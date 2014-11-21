(ns midpress.client
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]))

(defn get-request
  [url options]
  "Conduct a GET request to the server."
  (let [{:keys [status body]} (http/get url options)]
    (json/read-str body :key-fn keyword)))
