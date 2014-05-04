package com.geowarin

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableAutoConfiguration
@ComponentScan('com.geowarin')
@EnableWebSecurity
class App {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(App.class)
                .profiles(isHeroku() ? 'heroku' : 'dev')
                .run(args)
    }

    static boolean isHeroku() {
        System.getProperty('DYNO')
    }
}