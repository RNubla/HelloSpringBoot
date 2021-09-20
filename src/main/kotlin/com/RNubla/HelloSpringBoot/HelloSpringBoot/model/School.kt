package com.RNubla.HelloSpringBoot.HelloSpringBoot.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document("schools")
data class School (
    @Id
    val id: String? = null,
    var name: String,
    @Field("school_address")
    var address:String

)