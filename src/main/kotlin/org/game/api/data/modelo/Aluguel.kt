package org.game.api.data.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate) {
    val valor: Double = jogo.preco * Period.between(dataInicial, dataFinal).days

    override fun toString(): String {
        return "Aluguel(gamer=${gamer.nome}, jogo=${jogo.titulo}, dataInicial=$dataInicial, dataFinal=$dataFinal, valor=$valor)"
    }
}
