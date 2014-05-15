package com.geowarin.test

import com.github.fakemongo.Fongo
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule
import com.mongodb.Mongo
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by gewarin on 15/05/2014.
 */
@ContextConfiguration(classes = [MongoConfig])
abstract class FongoSpec extends Specification {

    @Autowired
    @SuppressWarnings("GroovyUnusedDeclaration")
    ApplicationContext applicationContext

    @Rule
    public MongoDbRule mongoDbRule = MongoDbRule.MongoDbRuleBuilder.newMongoDbRule().defaultSpringMongoDb("demo-test");

    @Configuration
    static class MongoConfig extends AbstractMongoConfiguration {

        @Override
        protected String getDatabaseName() {
            'demo-test'
        }

        @Override
        @Bean
        public Mongo mongo() {
            new Fongo('mongo-test').mongo
        }
    }
}
