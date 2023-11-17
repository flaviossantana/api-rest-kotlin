package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.entidade.GamerEntity
import org.game.api.data.dto.GamerDTO
import org.game.api.extensao.toEntity
import org.game.api.extensao.toGamer

class GamerDAO(private val manager: EntityManager): APIGamesDAO<GamerDTO>() {

    override fun todos(): List<GamerDTO> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { it.toGamer() }
    }

    override fun salvar(objeto: GamerDTO) {
        manager.transaction.begin()
        manager.persist(objeto.toEntity())
        manager.transaction.commit()
    }
}
