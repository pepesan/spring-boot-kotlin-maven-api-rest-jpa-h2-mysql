package com.cursosdedesarrollo.demokotlinmaven.services

import com.cursosdedesarrollo.demokotlinmaven.dto.Dato
import com.cursosdedesarrollo.demokotlinmaven.repositories.DatoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class DatoService
@Autowired
constructor(var datoRepository: DatoRepository)
{
    fun findAll(): List<Dato> {
        return this.datoRepository.findAll()
    }

    fun save(dato: Dato): Dato {
        return this.datoRepository.save(dato)
    }

    fun findById(id: Long): Optional<Dato> {
        return this.datoRepository.findById(id)
    }

    fun delete(dato: Dato){
        this.datoRepository.delete(dato)
    }
}