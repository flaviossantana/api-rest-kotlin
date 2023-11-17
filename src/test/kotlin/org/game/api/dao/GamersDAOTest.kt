package org.game.api.dao

import org.game.api.data.modelo.Gamer

fun main(){

    val entityManager = ConexaoDAO.getEntityManager()
    val gamerDAO = GamerDAO(entityManager)
    val gamer = Gamer("Jogador Numero #1", "play01@email.com")


    gamerDAO.salvar(gamer)

    val gamers = gamerDAO.getGamers()

    println(gamers)

}
