package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.JogoDTO
import org.game.api.data.entidade.JogoEntity
import org.game.api.extensao.toEntity
import org.game.api.extensao.toJogo

class JogoDAO(entityManager: EntityManager):
    APIGamesDAO<JogoDTO, JogoEntity>(entityManager, JogoEntity::class.java) {

    override fun toEntity(dto: JogoDTO): JogoEntity {
        return dto.toEntity()
    }

    override fun toDTO(entity: JogoEntity): JogoDTO {
        return entity.toJogo()
    }

}
