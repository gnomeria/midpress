# Midpress - WordPress Client for Clojure

A Clojure library designed to consume WordPress Rest API. It is a wrapper for [WP-API plugin](https://github.com/WP-API/WP-API "WP-API").
We are using it for our work-in-progress website version 2.0.

## Releases and Dependency Information

Latest stable release is 0.1.0

(Leiningen)[http://leiningen.org/] dependency information:

    [org.clojars.bepitulaz/midpress "0.1.0"]

(Gradle)[http://www.gradle.org/] dependency information:

    compile "org.clojars.bepitulaz:midpress:0.1.0"

(Maven)[http://maven.apache.org/] dependency information:

    <dependency>
      <groupId>org.clojars.bepitulaz</groupId>
      <artifactId>midpress</artifactId>
      <version>0.1.0</version>
    </dependency>

## Usage

Example usage:

    (ns example
      (:require [midpress.core :refer :all])

## API Documentation

Get recent posts:

    (the-loop "http://yourdomain.com/wp-json")
    
    ;; you can also give query string to it
    (the-loop "http://yourdomain.com/wp-json" "?posts_per_page=4&category_name=foodie")

Get single post:
    
    ;; you have to give the post ID to it
    (the-single "http://yourdomain.com/wp-json" 10)

Get taxonomies:
    
    ;; get all registered taxonomies
    (the-taxonomies "http://yourdomain.com/wp-json")

    ;; get taxonomy info by name
    (the-taxonomies "http://yourdomain.com/wp-json" "post_tag")

Get all categories:

    ;; get all registered categories
    (the-categories "http://yourdomain.com/wp-json")

For the complete query string option, please refer to (WP-API.org)[http://wp-api.org].

## License

Copyright © 2014 Midjournal

Distributed under the Eclipse Public License version 1.0.
