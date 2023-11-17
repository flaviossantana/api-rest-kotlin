package org.game.api.data.dto

abstract class PlanoDTO(var tipo: String) {

    open fun caucularAluguel(aluguelDTO: AluguelDTO): Double {
        return aluguelDTO.jogoDTO.preco * aluguelDTO.periodo.dias
    }

}
