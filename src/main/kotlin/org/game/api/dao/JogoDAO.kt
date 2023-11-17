package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.entidade.JogoEntity
import org.game.api.data.dto.JogoDTO
import org.game.api.extensao.toEntity
import org.game.api.extensao.toJogo

class JogoDAO(val entityManager: EntityManager) {

    fun salvar(jogoDTO: JogoDTO) {
        entityManager.transaction.begin()
        entityManager.persist(jogoDTO.toEntity())
        entityManager.transaction.commit()
    }

    fun todos(): List<JogoDTO> {
        val query = entityManager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { it.toJogo() }
    }
}
