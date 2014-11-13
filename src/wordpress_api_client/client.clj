(ns wordpress-api-client.client
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]))

(defn get-request
  [url]
  "Conduct a GET request to the server."
  (let [{:keys [status body]} (http/get url {:accept :json})]
    (json/read-str body :key-fn keyword)))
