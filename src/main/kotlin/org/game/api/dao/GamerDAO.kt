package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.GamerDTO
import org.game.api.data.entidade.GamerEntity
import org.game.api.extensao.toEntity
import org.game.api.extensao.toGamer

class GamerDAO(entityManager: EntityManager) :
    APIGamesDAO<GamerDTO, GamerEntity>(entityManager, GamerEntity::class.java) {

    override fun toEntity(dto: GamerDTO): GamerEntity {
        return dto.toEntity()
    }

    override fun toDTO(entity: GamerEntity): GamerDTO {
        return entity.toGamer()
    }


}
