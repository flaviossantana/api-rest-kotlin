package org.game.api.dao

import org.game.api.data.dto.PlanoAssinaturaDTO
import org.game.api.data.dto.PlanoAvulsoDTO

fun main(){

    val entityManager = ConexaoDAO.getEntityManager()
    val planoDAO = PlanoDAO(entityManager)

    val planoAvulso = PlanoAvulsoDTO("Plano Avulso")
    val planoAssinatura = PlanoAssinaturaDTO("Assianura Mensal", 29.90, 2, 10.0)

    planoDAO.salvar(planoAvulso)
    planoDAO.salvar(planoAssinatura)

    entityManager.close()
}
