package com.cursosdedesarrollo.demokotlinmaven.controllers

import com.cursosdedesarrollo.demokotlinmaven.dto.Dato
import com.cursosdedesarrollo.demokotlinmaven.repositories.DatoRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/redato")
class ResponseEntityDatoRepositoryController
    @Autowired
    constructor(var datoRepository: DatoRepository) {

    @GetMapping("/")
    fun index(): ResponseEntity<List<Dato>> {
        return ResponseEntity.ok(this.datoRepository.findAll())
    }
    @PostMapping("/")
    fun create(@Valid @RequestBody dato: Dato):  ResponseEntity<Dato>{
        this.datoRepository.save(dato)
        return ResponseEntity.ok(dato)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id")id: Long): ResponseEntity<Dato>{
        return ResponseEntity.ok(datoRepository.findById(id).orElse(null))
    }

    @PutMapping("/{id}")
    fun udpate(
        @PathVariable("id")id: Long,
        @Valid @RequestBody dato: Dato

    ): ResponseEntity<Dato>{
        val posibleDato = this.datoRepository.findById(id)
        val datoDevuelto: Dato
        if (posibleDato.isPresent){
            val datoReal = posibleDato.get()
            datoReal.cadena = dato.cadena
            this.datoRepository.save(datoReal)
            datoDevuelto  = datoReal
        }else{
            datoDevuelto = Dato()
        }
        return ResponseEntity.ok(datoDevuelto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id")id: Long): ResponseEntity<Dato>{
        val posibleDato = this.datoRepository.findById(id)
        val datoDevuelto: Dato
        if (posibleDato.isPresent){
            val datoReal = posibleDato.get()
            this.datoRepository.delete(datoReal)
            datoDevuelto  = datoReal
        }else{
            datoDevuelto = Dato()
        }
        return ResponseEntity.ok(datoDevuelto)
    }
}