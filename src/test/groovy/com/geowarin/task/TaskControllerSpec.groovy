package com.geowarin.task

import com.geowarin.test.FongoSpec
import com.lordofthejars.nosqlunit.annotation.UsingDataSet
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.test.context.ContextConfiguration

/**
 * Created by gewarin on 15/05/2014.
 */
@ContextConfiguration(classes = [TaskConfig])
class TaskControllerSpec extends FongoSpec {

    @Autowired
    private TaskController taskController

    @UsingDataSet(loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    def "should retrieve json from fongo"() {
        when:
        def res = taskController.findAllTasks()

        then:
        res == [new Task(author: 'joe')]
    }

    // Loads only from the task package
    @Configuration
    @ComponentScan(basePackageClasses = Task)
    @EnableMongoRepositories(basePackageClasses = TaskRepository)
    static class TaskConfig {
    }
}