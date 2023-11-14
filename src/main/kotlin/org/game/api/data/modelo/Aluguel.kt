package org.game.api.data.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,
    val periodo: Periodo) {
    val valor: Double = gamer.plano.caucularAluguel(this)



    override fun toString(): String {
        return "Aluguel(gamer=${gamer.nome}, jogo=${jogo.titulo}, periodo=$periodo, valor=$valor)"
    }
}
