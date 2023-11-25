package com.cursosdedesarrollo.demokotlinmaven.repositories

import com.cursosdedesarrollo.demokotlinmaven.dto.Dato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface DatoRepository: JpaRepository<Dato,Long>{
}