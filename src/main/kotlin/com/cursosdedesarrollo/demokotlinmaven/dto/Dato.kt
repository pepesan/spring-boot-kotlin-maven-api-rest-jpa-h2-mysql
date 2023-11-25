package com.cursosdedesarrollo.demokotlinmaven.dto

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
data class Dato(@Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                @NotBlank
                var id: Long = 0L,
                @NotNull
                var cadena: String = ""){
}