(ns wordpress-api-client.core-test
  (:require [clojure.test :refer :all]
            [wordpress-api-client.core :refer :all]))

(deftest the-loop-test
  (testing "Testing exception when site url isn't supplied."
    (is (thrown? Exception (the-loop)))))
