import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

/**
 *
 * Date: 19/04/2014
 * Time: 18:51
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@IntegrationTest
@WebAppConfiguration
@SpringApplicationConfiguration(classes = App.class)
class AppTest extends Specification {

    @Test
    def "test home"() {
        given:
        def template = new RestTemplate()

        when:
        def body = template.getForObject("http://localhost:8080/", String.class);

        then:
        body == "Hello World!"
    }

}
