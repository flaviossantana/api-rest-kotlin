package org.game.api.data.modelo

import org.game.api.client.GameCheapSharkClient
import org.game.api.client.GameHubClient
import org.game.api.client.GamerClient
import java.time.LocalDate


fun main() {

    val jogadores = GamerClient().buscaGamer()
    val jogos = GameHubClient().buscaJogos()

    val jogador = jogadores[2]
    val jogo = jogos[3]

    println(jogador)
    println(jogo)

    val aluguel = jogador.alugar(jogo, LocalDate.now(), LocalDate.now().plusDays(3))
    println(aluguel)

}



