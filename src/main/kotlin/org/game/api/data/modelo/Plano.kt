package org.game.api.data.modelo

data class Plano(
    var tipo: String
){

    fun caucularAluguel(aluguel: Aluguel): Double{
        return aluguel.jogo.preco * aluguel.periodo.dias
    }

}
