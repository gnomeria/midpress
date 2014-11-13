(ns midpress.core-test
  (:require [clojure.test :refer :all]
            [midpress.core :refer :all]))

(def siteurl "http://midjournal.com/wp-json")

(def not-found-siteurl "http://midjournal.com/wp-json/test")

;; Test for retrieving the posts
(deftest the-loop-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-loop)))))

(deftest the-loop-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-loop not-found-siteurl)))))

(deftest the-loop-success
  (testing "Testing if the request is success."
    (is (let [response (the-loop siteurl "?posts_per_page=2")]
          (contains? (last response) :title)))))

(deftest the-single-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-single)))))

(deftest the-single-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-single not-found-siteurl 1)))))

(deftest the-single-success
  (testing "Testing if the request is success."
    (is (let [response (the-single siteurl 2888)]
          (contains? response :title)))))

(deftest the-taxonomies-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-taxonomies)))))

(deftest the-taxonomies-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-taxonomies not-found-siteurl)))))

(deftest the-taxonomies-success
  (testing "Testing if the request is success."
    (is (let [response (the-taxonomies siteurl)]
          (contains? (last response) :name)))))

(deftest the-categories-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-categories)))))

(deftest the-categories-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-categories not-found-siteurl)))))

(deftest the-categories-success
  (testing "Testing if the request is success."
    (is (let [response (the-categories siteurl)]
          (contains? (last response) :ID)))))

