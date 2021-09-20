package com.RNubla.HelloSpringBoot.HelloSpringBoot.response

import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.School

class SchoolResponse(
    val id: String,
    val name: String,
    val address: String
) {
    companion object{
        fun fromEntity(school: School): SchoolResponse =
            SchoolResponse(
                id = school.id!!,
                name = school.name,
                address = school.address
            )
    }
}