package org.game.api.data.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valor: Double = jogo.preco * periodo.dias


    override fun toString(): String {
        return "Aluguel(gamer=${gamer.nome}, jogo=${jogo.titulo}, periodo=$periodo, valor=$valor)"
    }
}
