package com.geowarin.test.util

import com.geowarin.App
import com.github.fakemongo.Fongo
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule
import com.mongodb.Mongo
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.junit.Before
import org.junit.Rule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractMongoConfiguration
import org.springframework.test.context.web.WebAppConfiguration

/**
 * Created by gewarin on 15/05/2014.
 */
@IntegrationTest(['port=0', 'adminPassword=test'])
@WebAppConfiguration
@SpringApplicationConfiguration(classes = [App, FongoConfig])
abstract class AbstractFongoIntegrationTest {

    @Value('${local.server.port}')
    private int port
    @Value('${adminPassword}')
    protected String password
    protected String serverAddress

    @Autowired
    @SuppressWarnings("GroovyUnusedDeclaration")
    ApplicationContext applicationContext

    @Rule
    public MongoDbRule mongoDbRule = MongoDbRule.MongoDbRuleBuilder.newMongoDbRule().defaultSpringMongoDb("demo-test");

    @Before
    public void setUp() throws Exception {
        this.serverAddress = "http://localhost:$port"
    }

    protected static HttpResponse getWithBasicAuth(GString url, String userName, String password) {
        def authorization = Base64.encoder.encodeToString("$userName:$password".bytes);
        Request.Get(url)
                .addHeader('Authorization', "Basic $authorization")
                .execute().returnResponse()
    }

    @Configuration
    static class FongoConfig extends AbstractMongoConfiguration {

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
