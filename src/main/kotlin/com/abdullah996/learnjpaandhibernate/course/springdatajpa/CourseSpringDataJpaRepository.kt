package com.abdullah996.learnjpaandhibernate.course.springdatajpa

import com.abdullah996.learnjpaandhibernate.course.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseSpringDataJpaRepository : JpaRepository <Course,Long>  {

    // for custom methods should start with find by then name of variable start with capital case
    fun findByAuthor(author:String):List<Course>

    fun findByName(name:String):List<Course>

}