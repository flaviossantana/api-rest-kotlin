package org.game.api.data.modelo

abstract class Plano(var tipo: String) {

    open fun caucularAluguel(aluguel: Aluguel): Double {
        return aluguel.jogo.preco * aluguel.periodo.dias
    }

}
