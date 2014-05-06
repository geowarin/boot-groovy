package com.geowarin.task

import com.geowarin.App
import org.kubek2k.springockito.annotations.SpringockitoAnnotatedContextLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 *
 * Date: 06/05/2014
 * Time: 21:46
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@ContextConfiguration(classes = [App], loader = SpringockitoAnnotatedContextLoader)
class TaskServiceTest extends Specification {

    @Autowired
    TaskService taskService
    TaskRepository taskRepository = Mock()
//    @ReplaceWithMock TaskRepository taskRepository

    def setup() {
        taskService.taskRepository = taskRepository
    }

    def "should create task"() {
        when:
        taskService.createTask(name: 'kikoo')

        then:
        1 * taskRepository.save(_)
    }
}
