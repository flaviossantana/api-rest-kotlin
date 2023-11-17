package org.game.api.dao

import org.game.api.data.dto.GamerDTO

fun main(){

    val entityManager = ConexaoDAO.getEntityManager()
    val gamerDAO = GamerDAO(entityManager)
    val gamerDTO = GamerDTO("Jogador Numero #1", "play01@email.com")


    gamerDAO.salvar(gamerDTO)

    var gamers = gamerDAO.todos()

    println(gamers.size)

    val buscarPorId = gamerDAO.buscarPorId(gamers[gamers.size - 1].id)
    gamerDAO.excluir(buscarPorId.id)

    gamers = gamerDAO.todos()

    println(gamers.size)

}
