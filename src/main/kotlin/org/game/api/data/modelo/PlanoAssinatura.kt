package org.game.api.data.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int,
    val descontoReputacao: Double
) : Plano(tipo) {

    override fun caucularAluguel(aluguel: Aluguel): Double {

        val totalJogosAlugadosMes = aluguel.gamer.jogosDoMes(aluguel.periodo.inicio.monthValue).size

        return if (jogosInclusos > totalJogosAlugadosMes) {
            0.0
        } else {

            var valorAluguel = super.caucularAluguel(aluguel)

            if (aluguel.gamer.media > 8) {
                valorAluguel -= valorAluguel * descontoReputacao
            }

            valorAluguel
        }
    }
}

