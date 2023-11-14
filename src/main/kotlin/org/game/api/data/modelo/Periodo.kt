package org.game.api.data.modelo

import java.time.LocalDate
import java.time.Period

data class Periodo(
    val inicio: LocalDate,
    val final: LocalDate){
    val dias: Int = Period.between(inicio, final).days
}
