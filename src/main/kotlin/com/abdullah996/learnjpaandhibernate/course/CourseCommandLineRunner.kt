package com.abdullah996.learnjpaandhibernate.course

import com.abdullah996.learnjpaandhibernate.course.Course
import com.abdullah996.learnjpaandhibernate.course.jdbc.CourseJdbcRepository
import com.abdullah996.learnjpaandhibernate.course.jpa.CourseJpaRepository
import com.abdullah996.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CourseCommandLineRunner : CommandLineRunner {

    /*@Autowired
    private lateinit var repository: CourseJdbcRepository
*/
   /* @Autowired
    private lateinit var repository: CourseJpaRepository*/
    @Autowired
    private lateinit var repository: CourseSpringDataJpaRepository
    override fun run(vararg args: String?) {
        repository.save(Course(1,"test name","abdullah"))
        repository.save(Course(3,"test name 1","abdullah"))
        repository.save(Course(2,"test name 3","abdullah"))
        repository.deleteById(1)
        println(repository.findById(2))

        println(repository.findAll())
        println(repository.count())
        println(repository.findByAuthor("abdullah"))
        println(repository.findByAuthor(""))
        println(repository.findByName("test name 1"))
        println(repository.findByName("test name"))
    }
}