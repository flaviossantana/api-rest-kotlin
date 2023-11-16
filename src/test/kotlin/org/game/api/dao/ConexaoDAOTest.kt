package org.game.api.dao

import org.game.api.data.modelo.Jogo

fun main(){

    val jogo = Jogo(
        "Grand Theft Auto V",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/271590/header.jpg?t=1678296348",
        2.99,
        "Um jogo de ação em mundo aberto, onde você pode assumir o papel de três protagonistas e explorar uma cidade cheia de possibilidades.")

    JogoDAO().salvar(jogo)

    val todos = JogoDAO().todos()
    println(todos)


}
