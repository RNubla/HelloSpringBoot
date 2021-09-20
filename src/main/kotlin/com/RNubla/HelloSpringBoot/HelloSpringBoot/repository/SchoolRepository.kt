package com.RNubla.HelloSpringBoot.HelloSpringBoot.repository

import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.School
import org.springframework.data.mongodb.repository.MongoRepository

interface SchoolRepository : MongoRepository<School, String>