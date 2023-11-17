package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.entidade.JogoEntity
import org.game.api.data.modelo.Jogo
import org.game.api.extensao.toEntity
import org.game.api.extensao.toJogo

class JogoDAO(val entityManager: EntityManager) {

    fun salvar(jogo: Jogo) {
        entityManager.transaction.begin()
        entityManager.persist(jogo.toEntity())
        entityManager.transaction.commit()
    }

    fun todos(): List<Jogo> {
        val query = entityManager.createQuery("FROM JogoEntity", JogoEntity::class.java)
        return query.resultList.map { it.toJogo() }
    }
}
