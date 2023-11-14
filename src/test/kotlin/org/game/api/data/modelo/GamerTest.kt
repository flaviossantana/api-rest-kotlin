package org.game.api.data.modelo

import org.game.api.client.GameHubClient
import org.game.api.client.GamerClient
import java.time.LocalDate


fun main() {

    val jogadores = GamerClient().buscaGamer()
    val jogos = GameHubClient().buscaJogos()

    val jogadorN1 = jogadores[2]
    val jogadorN2 = jogadores[4]


    jogadorN1.plano = PlanoAvulso("BRONZE")
    jogadorN1.alugar(jogos[1], LocalDate.now(), LocalDate.now().plusDays(3))
    jogadorN1.alugar(jogos[2], LocalDate.now(), LocalDate.now().plusDays(4))
    jogadorN1.alugar(jogos[3], LocalDate.now(), LocalDate.now().plusDays(20))
    jogadorN1.alugar(jogos[4], LocalDate.now(), LocalDate.now().plusDays(6))

    println(jogadorN1)

    jogadorN2.plano = PlanoAssinatura("OURO", 59.90, 3)

    jogadorN2.jogos.add(jogos[5])
    jogadorN2.jogos.add(jogos[6])
    jogadorN2.jogos.add(jogos[7])
    jogadorN2.jogos.add(jogos[8])

    jogadorN2.alugar(jogadorN2.jogos[0] ?: jogos[5], LocalDate.now(), LocalDate.now().plusDays(30))
    jogadorN2.alugar(jogadorN2.jogos[1] ?: jogos[6], LocalDate.now(), LocalDate.now().plusDays(60))
    jogadorN2.alugar(jogadorN2.jogos[2] ?: jogos[7], LocalDate.now(), LocalDate.now().plusDays(90))
    jogadorN2.alugar(jogadorN2.jogos[3] ?: jogos[8], LocalDate.now(), LocalDate.now().plusDays(90))


    println(jogadorN2)

}




