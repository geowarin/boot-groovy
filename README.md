# Spring boot groovy

This demo application is designed to run on heroku.

Features :

1. Groovy + Gralde build
2. Fully tested (integration + spock unit tests)
3. Mongodb


## Deploy it

    heroku create myapp --buildpack https://github.com/heroku/heroku-buildpack-gradle
    heroku addons:add mongohq

To change the default password for the admin user, configure an environment variable called `adminPassword` in heroku

    git push heroku master
