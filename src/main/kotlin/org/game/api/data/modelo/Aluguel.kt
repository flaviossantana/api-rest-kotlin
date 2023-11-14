package org.game.api.data.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo
) {

    override fun toString(): String {
        return "Aluguel(gamer=${gamer.nome}, jogo=${jogo.titulo})"
    }

}
