package org.game.api.data.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int
) : Plano(tipo) {

    override fun caucularAluguel(aluguel: Aluguel): Double {
        val totalJogosAlugadosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.inicio.monthValue).size

        return if (jogosInclusos > totalJogosAlugadosMes) {
            0.0
        } else {
            super.caucularAluguel(aluguel)
        }
    }
}

