package com.cursosdedesarrollo.demokotlinmaven.controllers

import com.cursosdedesarrollo.demokotlinmaven.dto.Dato
import com.cursosdedesarrollo.demokotlinmaven.repositories.DatoRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/v1/dato")
class DatoRepositoryController
    @Autowired
    constructor(var datoRepository: DatoRepository) {

    @GetMapping("/")
    fun index(): List<Dato> {
        return this.datoRepository.findAll()
    }
    @PostMapping("/")
    fun create(@Valid @RequestBody dato: Dato): Dato{
        this.datoRepository.save(dato)
        return dato
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id")id: Long): Dato{
        return this.datoRepository.findById(id).orElse(null)
    }

    @PutMapping("/{id}")
    fun udpate(
        @PathVariable("id")id: Long,
        @Valid @RequestBody dato: Dato

    ): Dato{
        val posibleDato = this.datoRepository.findById(id)
        if (posibleDato.isPresent){
            val datoReal = posibleDato.get()
            datoReal.cadena = dato.cadena
            this.datoRepository.save(datoReal)
            return datoReal
        }else{
            return Dato()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id")id: Long): Dato{
        val posibleDato = this.datoRepository.findById(id)
        if (posibleDato.isPresent){
            val datoReal = posibleDato.get()
            this.datoRepository.delete(datoReal)
            return datoReal
        }else{
            return Dato()
        }
    }
}