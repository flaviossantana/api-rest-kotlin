package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.entidade.GamerEntity
import org.game.api.data.modelo.Gamer
import org.game.api.extensao.toEntity
import org.game.api.extensao.toGamer

class GamerDAO(private val manager: EntityManager) {

    fun getGamers(): List<Gamer> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { it.toGamer() }
    }

    fun salvar(gamer: Gamer) {
        manager.transaction.begin()
        manager.persist(gamer.toEntity())
        manager.transaction.commit()
    }
}
