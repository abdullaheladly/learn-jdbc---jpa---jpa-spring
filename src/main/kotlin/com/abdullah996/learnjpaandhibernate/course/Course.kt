package com.abdullah996.learnjpaandhibernate.course

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Course(
    @Id
    var id:Long?=null,
    var name:String?=null,
    var author:String?=null
)
