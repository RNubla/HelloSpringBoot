package com.RNubla.HelloSpringBoot.HelloSpringBoot.service

import com.RNubla.HelloSpringBoot.HelloSpringBoot.exception.NotFoundException
import com.RNubla.HelloSpringBoot.HelloSpringBoot.model.Student
import com.RNubla.HelloSpringBoot.HelloSpringBoot.repository.StudentRepository
import com.RNubla.HelloSpringBoot.HelloSpringBoot.request.StudentRequest
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val schoolService: SchoolService,
    private val studentRepository: StudentRepository
) {
    fun createStudent(request: StudentRequest): Student{
        val school = request.schoolId?.let { schoolService.findById(it) }
//        println("school $school ; request ${school::class.simpleName}")
        return studentRepository.save(
            Student(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email,
                school = school
            )
        )
    }
    fun findAll(): List<Student> =
        studentRepository.findAll()

    fun findAllBySchoolId(id: String): List<Student> =
        studentRepository.findBySchoolId(id)

    fun findById(id:ObjectId): Student =
        studentRepository.findById(id)
            .orElseThrow{NotFoundException("Student with id $id is not found")}

    fun updateStudent(id:ObjectId, request: StudentRequest): Student{
        val studentToUpdate = findById(id)
        val foundSchool = request.schoolId?.let { schoolService.findById(it) }

        return studentRepository.save(
            studentToUpdate.apply {
                firstName = request.firstName
                lastName = request.lastName
                email = request.email
                school = foundSchool
            }
        )
    }

    fun deleteById(id:ObjectId){
        val studentToDelete = findById(id)

        studentRepository.delete(studentToDelete)
    }
}