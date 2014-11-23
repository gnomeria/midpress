# Midpress - WordPress Client for Clojure

A Clojure library designed to consume WordPress Rest API. It is a wrapper for [WP-API plugin](https://github.com/WP-API/WP-API "WP-API").
We are using it for our work-in-progress website version 2.0.

## Releases and Dependency Information

Latest stable release is 0.3.0

[Leiningen](http://leiningen.org/) dependency information:

    [org.clojars.bepitulaz/midpress "0.3.0"]

[Gradle](http://www.gradle.org/) dependency information:

    compile "org.clojars.bepitulaz:midpress:0.3.0"

[Maven](http://maven.apache.org/) dependency information:

    <dependency>
      <groupId>org.clojars.bepitulaz</groupId>
      <artifactId>midpress</artifactId>
      <version>0.3.0</version>
    </dependency>

## Usage

Example usage:

    (ns example
      (:require [midpress.core :refer :all])

## API Documentation

Get recent posts:

    (the-loop {:url "http://yourdomain.com/wp-json"})
    
    ;; you can also give query string to it
    (the-loop {:url "http://yourdomain.com/wp-json" :query "?filter[posts_per_page]=4&filter[category_name]=foodie"})

Get the pages:
    (the-page {:url "http://yourdomain.com/wp-json"})
    
    ;; you can also give query string to it
    (the-page {:url "http://yourdomain.com/wp-json" :query "?filter[pagename]=about"})

For the complete query string option, please refer to [WP-API.org](http://wp-api.org).

Get single post:
    
    ;; you have to give the post ID to it
    (the-single {:url "http://yourdomain.com/wp-json" :postid 10})

Get taxonomies:
    
    ;; get all registered taxonomies
    (the-taxonomies {:url "http://yourdomain.com/wp-json"})

    ;; get taxonomy info by name
    (the-taxonomies {:url "http://yourdomain.com/wp-json" :taxonomy "post_tag"})

Get all categories:

    ;; get all registered categories
    (the-categories {:url "http://yourdomain.com/wp-json"})


Get the users. You need to install [Basic Auth plugin](https://github.com/WP-API/Basic-Auth) to your WordPress.

    ;; get specific user
    (the-users {:url "http://yourdomain.com/wp-json" :userid 1 :username "your-wp-username" :password "your-wp-password"})

    ;; get all users
    (the-users {:url "http://yourdomain.com/wp-json" :username "your-wp-username" :password "your-wp-password"})

## Changelog
version 0.3.0: Adding pages retrieval function.

version 0.2.0: Adding users retrieval function.

## License

Copyright © 2014 Midjournal

Distributed under the Eclipse Public License version 1.0.
