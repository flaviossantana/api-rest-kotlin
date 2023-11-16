package org.game.api.dao

import org.game.api.data.modelo.Jogo

fun main(){


    val entityManager = ConexaoDAO.getEntityManager()
    val jogoDao = JogoDAO(entityManager)

    val jogo = Jogo(
        "Grand Theft Auto V",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/271590/header.jpg?t=1678296348",
        2.99,
        "Um jogo de ação em mundo aberto, onde você pode assumir o papel de três protagonistas e explorar uma cidade cheia de possibilidades.")

    jogoDao.salvar(jogo)

    val todos = jogoDao.todos()
    println(todos)

    entityManager.close()
}
