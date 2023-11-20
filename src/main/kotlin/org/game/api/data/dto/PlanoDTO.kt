package org.game.api.data.dto

abstract class PlanoDTO(var tipo: String) {
    var id: Int = 0

    open fun caucularAluguel(aluguelDTO: AluguelDTO): Double {
        return aluguelDTO.jogoDTO.preco * aluguelDTO.periodo.dias
    }

}
