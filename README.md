# Spring boot groovy

This is a rest API demo application is designed to run on heroku.

Features :

1. Groovy + Gradle build
2. Fully tested (integration + spock unit tests)
3. Mongodb
4. Rest API documentation with swagger

## Debug (and hot reload) it

Download the [spring-loaded](https://github.com/spring-projects/spring-loaded) jar and add

    -javaagent:/path/to/spring-loaded.jar -noverify

As a JVM arg to your debug configuration and enjoy :)


## Deploy it

    heroku create myapp --buildpack https://github.com/heroku/heroku-buildpack-gradle
    heroku addons:add mongohq

To change the default password for the admin user, configure an environment variable called `adminPassword` in heroku

    git push heroku master
