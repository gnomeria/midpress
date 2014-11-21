(ns midpress.utils
  (:require [midpress.client :refer :all]))

(defmacro call-wp-api
  "Write codes for doing a request to the server."
  [{:keys [siteurl uri query username password]}]
  `(cond
    (and ~siteurl (nil? ~username) (nil? ~password)) (get-request (str ~siteurl ~uri ~query) {:accept :json})
    (and ~siteurl ~username ~password) (get-request (str ~siteurl ~uri ~query) {:accept :json
                                                                                :basic-auth [~username ~password]
                                                                                }) 
    :else (throw (Exception. "You should supply the function with your site url."))))
