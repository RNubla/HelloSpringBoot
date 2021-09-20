package com.RNubla.HelloSpringBoot.HelloSpringBoot.controller

import com.RNubla.HelloSpringBoot.HelloSpringBoot.request.SchoolRequest
import com.RNubla.HelloSpringBoot.HelloSpringBoot.response.SchoolResponse
import com.RNubla.HelloSpringBoot.HelloSpringBoot.service.SchoolService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/school")
class SchoolController(
    private val schoolService: SchoolService
) {
    @PostMapping
    fun createSchool(@RequestBody request: SchoolRequest) : ResponseEntity<SchoolResponse>{
        val createdSchool = schoolService.createSchool(request)

        return ResponseEntity.ok(
            SchoolResponse.fromEntity(createdSchool)
        )
    }

    @GetMapping
    fun findAllSchools(): ResponseEntity<List<SchoolResponse>>{
        val schools = schoolService.findAll()

        return ResponseEntity.ok(schools.map { SchoolResponse.fromEntity(it) })
    }

    @GetMapping("/{id}")
    fun findSchoolById(@PathVariable id: String): ResponseEntity<SchoolResponse>{
        val school = schoolService.findById(id)

        return ResponseEntity.ok(SchoolResponse.fromEntity(school))
    }

    @PutMapping("/{id}")
    fun updateSchool(
        @PathVariable id: String,
        @RequestBody request: SchoolRequest
    ): ResponseEntity<SchoolResponse>{
        val updatedSchool = schoolService.updateSchool(id, request)

        return ResponseEntity.ok( SchoolResponse.fromEntity(updatedSchool))
    }

    @DeleteMapping("/{id}")
    fun deleteSchool(@PathVariable id: String) : ResponseEntity<Void>{
        schoolService.deleteById(id)
        return ResponseEntity.noContent().build()
    }
}