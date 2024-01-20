package com.abdullah996.learnjpaandhibernate.course.jpa

import com.abdullah996.learnjpaandhibernate.course.Course
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
@Transactional
class CourseJpaRepository {
   // @Autowired
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    fun insert(course: Course){
        entityManager.merge(course)
    }

    fun findById(id:Long):Course?{
        return entityManager.find(Course::class.java,id)
    }

    fun deleteById(id: Long){
        val course =entityManager.find(Course::class.java,id)
        entityManager.remove(course)
    }
}