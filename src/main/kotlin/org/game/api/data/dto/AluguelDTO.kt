package org.game.api.data.dto

data class AluguelDTO(
    val gamerDTO: GamerDTO,
    val jogoDTO: JogoDTO,
    val periodo: PeriodoDTO) {
    val valor: Double = gamerDTO.planoDTO.caucularAluguel(this)



    override fun toString(): String {
        return "Aluguel(gamer=${gamerDTO.nome}, jogo=${jogoDTO.titulo}, periodo=$periodo, valor=$valor)"
    }
}
