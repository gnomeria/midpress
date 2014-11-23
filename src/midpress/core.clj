(ns midpress.core
  (:require [midpress.utils :refer :all]))

(defn the-loop
  "Retrieve posts. If it doesn't supply with any argument, it will
  retrieves 10 recent posts." 
  [{:keys [url query]}] 
  (try
    (call-wp-api {:siteurl url :uri "/posts" :query query})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn the-page
  "Retrieve all registered pages." 
  [{:keys [url query]}] 
  (try
    (call-wp-api {:siteurl url :uri "/pages" :query query})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn the-single
  "Show single post by post id." 
  [{:keys [url postid]}] 
  (try
    (call-wp-api {:siteurl url :uri "/posts/" :query postid})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))
  
(defn the-taxonomies
  "Retrieve a collection containing objects for each of 
  the site's registered taxonomies." 
  [{:keys [url taxonomy]}] 
  (try
    (if taxonomy 
      (call-wp-api {:siteurl url :uri "/taxonomies/" :query taxonomy})
      (call-wp-api {:siteurl url :uri "/taxonomies"}))
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn the-categories
  "Retrieve a collection containing objects for each of 
  the site's registered taxonomies." 
  [{:keys [url]}] 
  (try
    (call-wp-api {:siteurl url :uri "/taxonomies/category/terms"})
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))

(defn the-users
  "Retrieve user with or without id and it's needed basic authentication."
  [{:keys [url username password userid]}]
  (try
    (if userid
      (call-wp-api {:siteurl url :uri (str "/users/" userid) :username username :password password})  
      (call-wp-api {:siteurl url :uri "/users" :username username :password password})) 
    (catch clojure.lang.ExceptionInfo e (str (.getMessage e)))))
