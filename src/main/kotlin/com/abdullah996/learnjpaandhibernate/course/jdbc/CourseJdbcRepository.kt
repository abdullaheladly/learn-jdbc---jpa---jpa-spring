package com.abdullah996.learnjpaandhibernate.course.jdbc

import com.abdullah996.learnjpaandhibernate.course.Course
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.queryForObject
import org.springframework.stereotype.Repository


@Repository
class CourseJdbcRepository {

    companion object{
        private const val INSERT_QUERY = """
                 insert into course (id, name,author)
                 values(?,?,?);
        """

        private const val DELETE_QUERY = """
                 delete from course where id=?
           
              
        """

        private const val SELECT_BY_ID_QUERY = """
                 select * from course where id=?
           
              
        """
    }
    @Autowired
    private lateinit var springJdbcTemplate:JdbcTemplate

    fun insert(course: Course){
        springJdbcTemplate.update(INSERT_QUERY,course.id,course.name,course.author)
    }

    fun delete(id:Long){
        springJdbcTemplate.update(DELETE_QUERY,id)
    }

    fun select(id:Long):Course?{
        return springJdbcTemplate.queryForObject(SELECT_BY_ID_QUERY,BeanPropertyRowMapper(Course::class.java),id)
    }
}