package org.game.api.data.modelo

class PlanoAvulso(tipo: String) : Plano(tipo) {

    override fun caucularAluguel(aluguel: Aluguel): Double {

        var valorAluguel = super.caucularAluguel(aluguel)

        if (aluguel.gamer.media > 8) {
            valorAluguel -= valorAluguel * 0.1
        }

        return valorAluguel
    }

}
