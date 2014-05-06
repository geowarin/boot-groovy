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
    private TaskService service

    @Autowired
    TaskController(TaskService service) {
        this.service = service
    }

    @RequestMapping('/all')
    public List<Task> findAllTasks() {
        service.findAll()
    }


}
