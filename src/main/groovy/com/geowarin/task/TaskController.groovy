package com.geowarin.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * Date: 04/05/2014
 * Time: 17:25
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@RestController
@RequestMapping('/task')
class TaskController {
    private TaskRepository repository

    @Autowired
    TaskController(TaskRepository repository) {
        this.repository = repository
    }

    @RequestMapping('/all')
    public List<Task> findAllTasks() {
        repository.findAll()
    }


}
