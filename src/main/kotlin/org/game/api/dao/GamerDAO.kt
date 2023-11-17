package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.entidade.GamerEntity
import org.game.api.data.dto.GamerDTO
import org.game.api.extensao.toEntity
import org.game.api.extensao.toGamer

class GamerDAO(private val manager: EntityManager) {

    fun getGamers(): List<GamerDTO> {
        val query = manager.createQuery("FROM GamerEntity", GamerEntity::class.java)
        return query.resultList.map { it.toGamer() }
    }

    fun salvar(gamerDTO: GamerDTO) {
        manager.transaction.begin()
        manager.persist(gamerDTO.toEntity())
        manager.transaction.commit()
    }
}
