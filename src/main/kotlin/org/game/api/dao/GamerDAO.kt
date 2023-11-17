package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.GamerDTO
import org.game.api.extensao.toEntity

class GamerDAO(entityManager : EntityManager): APIGamesDAO<GamerDTO>(entityManager) {

    override fun toEntity(objeto: GamerDTO) {
        objeto.toEntity()
    }

    override fun todos(): List<GamerDTO> {
        TODO("Not yet implemented")
    }


}
