(ns midpress.core-test
  (:require [clojure.test :refer :all]
            [midpress.core :refer :all]))

(def siteurl "http://midjournal.com/wp-json")

(def not-found-siteurl "http://midjournal.com/wp-json/test")

;; Test for retrieving the posts
(deftest the-loop-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-loop {:uri "/posts" :query nil :username nil :password nil})))))

(deftest the-loop-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-loop {:url not-found-siteurl :query nil :username nil :password nil})))))

(deftest the-loop-success
  (testing "Testing if the request is success."
    (is (let [response (the-loop {:url siteurl :query "?filter[posts_per_page]=2"})]
          (= 2 (count response))))))

(deftest the-single-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-single)))))

(deftest the-single-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-single {:url not-found-siteurl :postid 1})))))

(deftest the-single-success
  (testing "Testing if the request is success."
    (is (let [response (the-single {:url siteurl :postid 2888})]
          (contains? response :title)))))

(deftest the-taxonomies-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-taxonomies {:taxonomy "post_tag"})))))

(deftest the-taxonomies-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-taxonomies {:url not-found-siteurl})))))

(deftest the-taxonomies-success
  (testing "Testing if the request is success."
    (is (let [response (the-taxonomies {:url siteurl :taxonomy "post_tag"})]
          (= "post_tag" (:slug response))))))

(deftest the-list-all-taxonomies-success
  (testing "Testing if the request to list all taxonomies is success."
    (is (let [response (the-taxonomies {:url siteurl})]
          (contains? (last response) :name)))))

(deftest the-categories-fail-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-categories {:url nil})))))

(deftest the-categories-404
  (testing "Testing the routes is 404 not found."
    (is (= "clj-http: status 404" (the-categories {:url not-found-siteurl})))))

(deftest the-categories-success
  (testing "Testing if the request is success."
    (is (let [response (the-categories {:url siteurl})]
          (contains? (last response) :ID)))))

(deftest the-users-fail-test
  (testing "Testing exception when site url isn't supplied to users endpoint."
    (is (thrown? Exception (the-users {:url nil})))))

(deftest the-users-404
  (testing "Testing the routes for 404 not found to users endpoint."
    (is (= "clj-http: status 404" (the-users {:url not-found-siteurl})))))

(deftest the-users-success
  (testing "Testing if the request is success to users endpoint."
    ;; Todo: it should fake for publishing it on Github
    (is (let [response (the-users {:url siteurl :username "username" :password "password" :userid 1})]
          (= 1 (:ID response))))))

