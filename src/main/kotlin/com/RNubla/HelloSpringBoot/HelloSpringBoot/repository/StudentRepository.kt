package com.RNubla.HelloSpringBoot.HelloSpringBoot.repository

import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.Student
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface StudentRepository : MongoRepository<Student, ObjectId>{
    fun findBySchoolId(id: String): List<Student>
}