package org.game.api.dao

import org.game.api.data.dto.AluguelDTO
import org.game.api.data.dto.PeriodoDTO

fun main(){

    val entityManager = ConexaoDAO.getEntityManager()
    val aluguelDAO = AluguelDAO(entityManager)
    val gamerDAO = GamerDAO(entityManager)
    val jogoDAO = JogoDAO(entityManager)

    val  jogo = jogoDAO.buscarPorId(1)
    val jogadorUM = gamerDAO.buscarPorId(1)

    val aluguel = AluguelDTO(jogadorUM, jogo, PeriodoDTO())

    aluguelDAO.salvar(aluguel)

}
