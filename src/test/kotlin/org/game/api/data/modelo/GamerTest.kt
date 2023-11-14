package org.game.api.data.modelo

import org.game.api.client.GameClient
import org.game.api.client.GamerClient


fun main() {

    val jogadores = GamerClient().buscaGamer()
    val jogo = GameClient().buscaJogo("128")

    val jogador = jogadores[2]

    println(jogador)
    println(jogo)

    val aluguel = jogador.alugar(jogo)
    println(aluguel)


}



