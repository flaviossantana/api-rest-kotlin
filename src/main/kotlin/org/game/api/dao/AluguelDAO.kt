package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.AluguelDTO
import org.game.api.data.entidade.AluguelEntity
import org.game.api.extensao.toAluguel
import org.game.api.extensao.toEnttity

class AluguelDAO(entitiManager: EntityManager):
    APIGamesDAO<AluguelDTO, AluguelEntity>(entitiManager, AluguelEntity::class.java) {

    override fun toEntity(dto: AluguelDTO): AluguelEntity {
        return dto.toEnttity().apply {
            valor = dto.valor
            id = dto.id
        }
    }

    override fun toDTO(entity: AluguelEntity): AluguelDTO {
        return entity.toAluguel().apply {
            id = entity.id
        }
    }
}
