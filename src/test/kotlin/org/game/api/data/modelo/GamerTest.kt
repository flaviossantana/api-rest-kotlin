package org.game.api.data.modelo

import org.game.api.client.GameHubClient
import org.game.api.client.GamerClient
import java.time.LocalDate


fun main() {

    val jogadores = GamerClient().buscaGamer()
    val jogos = GameHubClient().buscaJogos()

    val jogador = jogadores[2]



    jogador.alugar(jogos[1], LocalDate.now(), LocalDate.now().plusDays(3))
    jogador.alugar(jogos[2], LocalDate.now(), LocalDate.now().plusDays(4))
    jogador.alugar(jogos[3], LocalDate.now(), LocalDate.now().plusDays(20))
    jogador.alugar(jogos[4], LocalDate.now(), LocalDate.now().plusDays(6))

    println(jogador)

}



