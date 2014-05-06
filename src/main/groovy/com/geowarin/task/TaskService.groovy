package com.geowarin.task

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *
 * Date: 06/05/2014
 * Time: 21:40
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Service
class TaskService {
    @Autowired
    protected TaskRepository taskRepository

    public Task createTask(name) {
        taskRepository.save(new Task(name: name))
    }

    public List<Task> findAll() {
        taskRepository.findAll()
    }
}
