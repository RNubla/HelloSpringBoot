package com.RNubla.HelloSpringBoot.HelloSpringBoot.response

import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.Student

class StudentResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val school: SchoolResponse?
){
    companion object{
        fun fromEntity(student: Student): StudentResponse = StudentResponse(
            id = student.id!!.toHexString(),
            firstName = student.firstName,
            lastName = student.lastName,
            email = student.email,
            school = student.school?.let { SchoolResponse.fromEntity(it) }
        )
    }
}