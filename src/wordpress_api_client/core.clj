(ns wordpress-api-client.core
  (:require [wordpress-api-client.utils :refer :all]))

(defn the-loop
  [siteurl & [query]]
  "Retrieve posts. If it doesn't supply with any argument, it will
  retrieves 10 recent posts."
  (try 
    (call-wp-api {:siteurl siteurl :uri "/posts" :query query})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))


(defn the-single
  [siteurl post-id]
  "Show single post by post id."
  (try
    (call-wp-api {:siteurl siteurl :uri "/posts/" :query post-id})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))
  
(defn the-taxonomies
  [siteurl & [taxonomy]]
  "Retrieve a collection containing objects for each of 
  the site's registered taxonomies."
  (try
    (if taxonomy 
      (call-wp-api {:siteurl siteurl :uri "/taxonomies/" :query taxonomy})
      (call-wp-api {:siteurl siteurl :uri "/taxonomies" :query ""}))
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn the-categories
  [siteurl]
  "Retrieve a collection containing objects for each of 
  the site's registered taxonomies."
  (try
    (call-wp-api {:siteurl siteurl :uri "/taxonomies/category/terms" :query ""})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))
