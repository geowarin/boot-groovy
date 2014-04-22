import spock.lang.Specification
import spock.lang.Unroll


/**
 *
 * Date: 20/04/2014
 * Time: 17:08
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class TestSpec extends Specification {

    @Unroll("length of #name is #length")
    def "Length of names"() {
        expect:
        name.size() == length

        where:
        name << ["jean", "hello"]
        length << [4, 5]
    }
}