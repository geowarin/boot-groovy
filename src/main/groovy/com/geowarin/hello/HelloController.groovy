package com.geowarin.hello

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * Date: 04/05/2014
 * Time: 17:45
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RestController
class HelloController {

    @Autowired
    private Environment env;

    @RequestMapping("/")
    String home() {
        "Hello $env.activeProfiles World!"
    }
}