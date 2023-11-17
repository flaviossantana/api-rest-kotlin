package org.game.api.data.dto

import java.time.LocalDate
import java.time.Period

data class PeriodoDTO(
    val inicio: LocalDate,
    val final: LocalDate){
    val dias: Int = Period.between(inicio, final).days
}
