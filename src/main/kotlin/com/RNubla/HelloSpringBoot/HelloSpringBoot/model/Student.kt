package com.RNubla.HelloSpringBoot.HelloSpringBoot.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

data class Student (
    @Id
    val id: ObjectId? = null,
    var firstName: String,
    var lastName: String,
    var email: String,
    var school: School?,
)