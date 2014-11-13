(ns wordpress-api-client.utils
  (:require [wordpress-api-client.client :refer :all]))

(defmacro call-wp-api
  "Write codes for doing a request to the server."
  [{:keys [siteurl uri query]}]
  `(if ~siteurl 
     (get-request (str ~siteurl ~uri ~query))
     (throw (Exception. "You should supply the function with your site url."))))
