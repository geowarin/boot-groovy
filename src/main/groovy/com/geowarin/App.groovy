package com.geowarin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@EnableAutoConfiguration
@ComponentScan("com.geowarin")
@EnableWebSecurity
class App {

    @RequestMapping("/")
    String home() {
        'Hello World!'
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args)
    }
}