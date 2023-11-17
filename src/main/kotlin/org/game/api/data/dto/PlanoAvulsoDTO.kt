package org.game.api.data.dto

class PlanoAvulsoDTO(tipo: String) : PlanoDTO(tipo) {

    override fun caucularAluguel(aluguelDTO: AluguelDTO): Double {

        var valorAluguel = super.caucularAluguel(aluguelDTO)

        if (aluguelDTO.gamerDTO.media > 8) {
            valorAluguel -= valorAluguel * 0.1
        }

        return valorAluguel
    }

}
