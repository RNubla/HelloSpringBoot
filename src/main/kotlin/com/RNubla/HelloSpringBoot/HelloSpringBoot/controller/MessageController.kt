package com.RNubla.HelloSpringBoot.HelloSpringBoot.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/message")
class MessageController {

    @GetMapping("/hello")
    fun hello():String{
        return "Full stack Spring Boot and Vue"
    }


}