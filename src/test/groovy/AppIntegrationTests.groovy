import com.geowarin.App
import org.apache.http.HttpResponse
import org.apache.http.client.fluent.Request
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate

/**
 *
 * Date: 19/04/2014
 * Time: 18:51
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest(["port=0", "password=test"])
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
class AppIntegrationTests {

    @Value('${local.server.port}')
    private int port;
    @Value('${security.user.password}')
    private String password;

    String serverAddress

    @Before
    public void setUp() throws Exception {
        this.serverAddress = "http://localhost:${port}"
    }

    @Test
    def void should_access_home() {
        def body = new RestTemplate().getForObject(serverAddress, String.class);
        assert body == "Hello World!"
    }

    @Test
    def void should_secure_sensible_resources() {
        def httpResponse = Request.Get("${serverAddress}/management/beans").execute().returnResponse()
        assert httpResponse.getStatusLine().getStatusCode() == 401

        assert password == 'test'
        httpResponse = getWithBasicAuth("${serverAddress}/management/beans", 'admin', password)
        assert httpResponse.getStatusLine().getStatusCode() == 200
    }

    private static HttpResponse getWithBasicAuth(GString url, String userName, String password) {
        def authorization = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes());
        Request.Get(url)
                .addHeader("Authorization", "Basic " + authorization)
                .execute().returnResponse()
    }
}
