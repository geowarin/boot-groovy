package com.geowarin

import com.geowarin.test.util.AbstractFongoIntegrationTest
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.web.client.RestTemplate

/**
 *
 * Date: 19/04/2014
 * Time: 18:51
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RunWith(SpringJUnit4ClassRunner)
class AppIntegrationTests extends AbstractFongoIntegrationTest {

    @Test
    def void should_access_home() {
        def body = new RestTemplate().getForObject(serverAddress, String.class);
        assert body == 'Hello [] World!'
    }

    @Test
    def void should_access_non_sensible_resources() {
        def httpResponse = Request.Get("$serverAddress/management/info").execute().returnResponse()
        assert httpResponse.statusLine.statusCode == 200
    }

    @Test
    def void should_secure_sensible_resources() {
        def httpResponse = Request.Get("$serverAddress/management/beans").execute().returnResponse()
        assert httpResponse.statusLine.statusCode == 401

        httpResponse = getWithBasicAuth("$serverAddress/management/beans", 'admin', password)
        assert httpResponse.statusLine.statusCode == 200
    }

    @Test
    def void should_secure_api_doc() {
        def httpResponse = Request.Get("$serverAddress/documentation.html").execute().returnResponse()
        assert httpResponse.statusLine.statusCode == 401

        httpResponse = Request.Get("$serverAddress/documentation/resourceList").execute().returnResponse()
        assert httpResponse.statusLine.statusCode == 401
    }
}
