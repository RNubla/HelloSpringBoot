package com.RNubla.HelloSpringBoot.HelloSpringBoot.service

import com.RNubla.HelloSpringBoot.HelloSpringBoot.exception.NotFoundException
import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.School
import com.RNubla.HelloSpringBoot.HelloSpringBoot.repository.SchoolRepository
import com.RNubla.HelloSpringBoot.HelloSpringBoot.repository.StudentRepository
import com.RNubla.HelloSpringBoot.HelloSpringBoot.request.SchoolRequest
import org.springframework.stereotype.Service
/*
* {
  "id": "614817302bd05a38e2593f99",
  "name": "WCU",
  "address": "address1"
}
* */
@Service
class SchoolService (
    private val schoolRepository: SchoolRepository,
    private val studentRepository: StudentRepository
){
    fun createSchool(request: SchoolRequest): School =
        schoolRepository.save(
            School(
                name = request.name,
                address = request.address
            )
        )
    fun findAll(): List<School> =
        schoolRepository.findAll()

    fun findById(id:String): School=
        schoolRepository.findById(id)
            .orElseThrow{NotFoundException("School with id $id is not found")}

    fun updateSchool(id:String, request: SchoolRequest): School{
        val schoolToUpdate = findById(id)

        val updatedSchool = schoolRepository.save(
            schoolToUpdate.apply {
                name = request.name
                address = request.address
            }
        )
        updateSchoolStudents(updatedSchool)
        return updatedSchool
    }
    fun deleteById(id: String){
        val companyToDelete = findById(id)
        schoolRepository.delete(companyToDelete)
    }
    private fun updateSchoolStudents(updatedSchool: School){
        studentRepository.saveAll(
            studentRepository.findBySchoolId(updatedSchool.id!!)
                .map { it.apply { school = updatedSchool } }
        )
    }
}