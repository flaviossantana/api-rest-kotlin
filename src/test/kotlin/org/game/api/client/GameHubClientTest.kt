package org.game.api.client


fun main() {

    val jogos = GameHubClient().buscaJogos()

    println(jogos)

    val jogo = jogos[3]

    println(jogo)

}

