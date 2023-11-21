package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.PlanoDTO
import org.game.api.data.entidade.PlanoEntity
import org.game.api.extensao.toDTO
import org.game.api.extensao.toEntity

class PlanoDAO(entityManager: EntityManager) :
    APIGamesDAO<PlanoDTO, PlanoEntity>(entityManager, PlanoEntity::class.java) {

    override fun toEntity(dto: PlanoDTO): PlanoEntity {
        return  dto.toEntity()
    }

    override fun toDTO(entity: PlanoEntity): PlanoDTO {
        return entity.toDTO().apply { id = entity.id }
    }


}
