(ns midpress.client
  (:require [clj-http.client :as http]
            [clojure.data.json :as json]))

(defn get-request
  [url options]
  "Conduct a GET request to the server."
  (let [{:keys [headers links body]} (http/get url options)]
    {:links links :headers headers :body (json/read-str body :key-fn keyword)}))
