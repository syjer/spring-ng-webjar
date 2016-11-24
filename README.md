# Spring + angular + webjar + wro4j + jasmine

This is a simple template/example for a spring web app which:

 - use webjars for handling the (js/css) dependencies
 - use wro4j for handling the concatenation of the third party js/css resources _offline_
 - use wro4j for handling the concatenation of the application resources at runtime for enabling a simpler dev cycle
 - use jasmine for bdd tests

## Open issue:

The saga-maven-plugin does not generate the correct coverage for the angular app.


## Third party dependencies

Currently, we are including angularjs / ui-router and bootstrap as a third party dependencies.
The configuration for including dependencies must be done in 2 phases:

  - first add in the pom.xml in the wro4j-maven-plugin section your webjar dependency
  - edit src/main/wro/wro.xml to include your resource

## Launch jasmine tests:

For developing the tests:

```
mvn jasmine:bdd
```



## Based on:

- https://github.com/akquinet/angularjs-blog
- https://github.com/spring-guides/tut-spring-security-and-angular-js
- https://puigcerber.com/2016/02/07/how-to-test-angular-1-5-components/
- http://wro4j.readthedocs.io/en/stable/ConfigureWro4jViaSpring/
- http://www.pseudobry.com/jasmine-maven-requirejs-coverage/
- https://searls.github.io/jasmine-maven-plugin/code-coverage.html
- https://github.com/NitorCreations/willow/blob/master/willow-servers/pom.xml
- https://github.com/timurstrekalov/saga/issues/35
- http://ahexamples.blogspot.ch/2014/03/example-of-jasmine-saga-sonar-maven.html
