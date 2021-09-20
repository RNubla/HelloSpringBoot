package com.RNubla.HelloSpringBoot.HelloSpringBoot.controller

import com.RNubla.HelloSpringBoot.HelloSpringBoot.request.StudentRequest
import com.RNubla.HelloSpringBoot.HelloSpringBoot.response.StudentResponse
import com.RNubla.HelloSpringBoot.HelloSpringBoot.service.StudentService
import org.bson.types.ObjectId
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/student")
class StudentController (
    private val studentService: StudentService
) {
    @PostMapping
    fun createStudent(@RequestBody request: StudentRequest): ResponseEntity<StudentResponse>{
//        println(request.schoolId)
        val createdStudent = studentService.createStudent(request)
        return ResponseEntity.ok(StudentResponse.fromEntity(createdStudent))
    }

    @GetMapping
    fun findAllStudent(): ResponseEntity<List<StudentResponse>>{
        val students = studentService.findAll()
        return ResponseEntity.ok(students.map { StudentResponse.fromEntity(it) })
    }

    @GetMapping("/{id}")
    fun findStudentById(@PathVariable id: ObjectId) : ResponseEntity<StudentResponse>{
        val student = studentService.findById(id)
        return  ResponseEntity.ok(StudentResponse.fromEntity(student))
    }

    @GetMapping("/school/{schoolId}")
    fun findAllBySchoolId(@PathVariable schoolId: String ): ResponseEntity<List<StudentResponse>>{
        val students = studentService.findAllBySchoolId(schoolId)

        return ResponseEntity.ok(students.map { StudentResponse.fromEntity(it) })
    }

    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id:ObjectId, @RequestBody request: StudentRequest): ResponseEntity<StudentResponse>
    {
        val updatedStudent = studentService.updateStudent(id, request)
        return ResponseEntity.ok(StudentResponse.fromEntity(updatedStudent))
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: ObjectId): ResponseEntity<Void>{
        studentService.deleteById(id)

        return ResponseEntity.noContent().build()
    }
}