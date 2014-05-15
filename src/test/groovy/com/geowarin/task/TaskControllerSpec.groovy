package com.geowarin.task

import com.geowarin.test.FongoSpec
import com.lordofthejars.nosqlunit.annotation.UsingDataSet
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by gewarin on 15/05/2014.
 */
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

}