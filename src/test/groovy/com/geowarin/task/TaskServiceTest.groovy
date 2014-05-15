package com.geowarin.task

import com.geowarin.App
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 *
 * Date: 06/05/2014
 * Time: 21:46
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@SuppressWarnings("GroovyAssignabilityCheck")
@ContextConfiguration(classes = [App])
class TaskServiceTest extends Specification {

    @Autowired
    TaskService taskService

    TaskRepository taskRepository = Mock(TaskRepository)

    def setup() {
        taskService.taskRepository = taskRepository
    }

    def "should create task"() {
        when:
            def task = taskService.createTask(name: 'kikoo')

        then:
            1 * taskRepository.save(_) >> new Task(name: 'mocked')
            task.name == 'mocked'
    }

    def "should intercept arg"() {
        when:
            def task = taskService.createTask(author: 'jean', name: 'kikoo')

        then:
            1 * taskRepository.save(_) >> { arg ->
                assert arg instanceof List
                assert arg[0] instanceof Task
                new Task(name: 'mocked')
            }
            task.name == 'mocked'
    }
}
