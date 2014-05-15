package com.geowarin.task

import com.geowarin.App
import com.geowarin.test.FongoSpec
import org.hamcrest.Matchers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

import static org.hamcrest.Matchers.*

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

/**
 *
 * Date: 15/05/2014
 * Time: 22:02
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@ContextConfiguration(classes = [App])
@WebAppConfiguration
class TaskSpec extends FongoSpec {

    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc


    def setup() {
        DefaultMockMvcBuilder mockMvcBuilder = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        mockMvc = mockMvcBuilder.build()
    }

    def "should work"() {

        when:
        def perform = mockMvc.perform(get('/task/all'));

        then:
        perform.andExpect(jsonPath('$[0].name', Matchers.is('test')))
                .andExpect(jsonPath('$[0].author', Matchers.is('Cedric')));
    }
}
