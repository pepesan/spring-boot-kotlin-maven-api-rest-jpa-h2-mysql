package com.cursosdedesarrollo.demokotlinmaven.controllers

import com.cursosdedesarrollo.demokotlinmaven.dto.Dato
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping("/")
    fun index(): Dato {
        return Dato()
    }
}