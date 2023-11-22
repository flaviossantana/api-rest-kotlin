package org.game.api.data.dto

import jakarta.persistence.Embeddable
import java.time.LocalDate
import java.time.Period

@Embeddable
data class PeriodoDTO(
    val inicio: LocalDate = LocalDate.now(),
    val final: LocalDate = LocalDate.now().plusDays(7)){
    val dias: Int = Period.between(inicio, final).days
}
