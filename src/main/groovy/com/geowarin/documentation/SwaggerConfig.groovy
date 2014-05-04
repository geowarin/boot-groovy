package com.geowarin.documentation

import com.knappsack.swagger4springweb.controller.ApiDocumentationController
import com.knappsack.swagger4springweb.util.ScalaObjectMapper
import com.wordnik.swagger.model.ApiInfo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 *
 * Date: 04/05/2014
 * Time: 19:27
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Configuration
@Controller
@RequestMapping(value = "/documentation")
class SwaggerConfig  extends ApiDocumentationController {

    @Bean
    MappingJackson2HttpMessageConverter jacksonConverter() {
        def converter = new MappingJackson2HttpMessageConverter()
        converter.setObjectMapper(new ScalaObjectMapper())
        converter
    }

    SwaggerConfig() {
        setBaseControllerPackage("com.geowarin");
        setBaseModelPackage("com.geowarin");
        setApiVersion("v1");
        setApiInfo(new ApiInfo("Boot Groovy App", "Boot groovy app on heroku", null, null, null, null));
    }

    @RequestMapping
    String doc() {
        "/doc.html"
    }
}
