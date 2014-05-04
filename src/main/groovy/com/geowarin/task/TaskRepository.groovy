package com.geowarin.task

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 *
 * Date: 04/05/2014
 * Time: 17:24
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Repository
interface TaskRepository extends MongoRepository<Task, Long> {
}
