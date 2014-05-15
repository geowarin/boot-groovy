package com.geowarin.task

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.springframework.data.mongodb.core.mapping.Document

/**
 *
 * Date: 04/05/2014
 * Time: 17:18
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@Document
@Canonical
@ToString(includeNames = true)
class Task {
    String name
    String author
    String initialCode
    String targetCode
}
