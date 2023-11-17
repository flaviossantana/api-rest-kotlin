package org.game.api.data.dto

class PlanoAssinaturaDTO(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int,
    val descontoReputacao: Double
) : PlanoDTO(tipo) {

    override fun caucularAluguel(aluguelDTO: AluguelDTO): Double {

        val totalJogosAlugadosMes = aluguelDTO.gamerDTO.jogosDoMes(aluguelDTO.periodo.inicio.monthValue).size

        return if (jogosInclusos > totalJogosAlugadosMes) {
            0.0
        } else {

            var valorAluguel = super.caucularAluguel(aluguelDTO)

            if (aluguelDTO.gamerDTO.media > 8) {
                valorAluguel -= valorAluguel * descontoReputacao
            }

            valorAluguel
        }
    }
}

