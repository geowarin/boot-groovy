package com.geowarin.task

import com.geowarin.test.util.AbstractFongoIntegrationTest
import com.lordofthejars.nosqlunit.annotation.UsingDataSet
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum
import groovy.json.JsonSlurper
import org.apache.http.client.fluent.Request
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 *
 * Date: 19/04/2014
 * Time: 18:51
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RunWith(SpringJUnit4ClassRunner)
class TaskIntegrationTest extends AbstractFongoIntegrationTest {

    @Test
    @UsingDataSet(loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    def void should_fetch_all_tasks() {
        def httpResponse = Request.Get("$serverAddress/task/all").execute().returnResponse()
        assert httpResponse.statusLine.statusCode == 200

        def tasksJson = new JsonSlurper().parse(httpResponse.entity.content)
        assert tasksJson.size() == 1
        assert tasksJson[0].author == 'joe'
    }
}
