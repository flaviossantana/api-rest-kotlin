package org.game.api.data.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int
) : Plano(tipo){

    override fun caucularAluguel(aluguel: Aluguel): Double {
        return super.caucularAluguel(aluguel)
    }

}

