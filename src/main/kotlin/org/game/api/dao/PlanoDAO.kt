package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.PlanoAssinaturaDTO
import org.game.api.data.dto.PlanoAvulsoDTO
import org.game.api.data.dto.PlanoDTO
import org.game.api.data.entidade.PlanoAssinaturaEntity
import org.game.api.data.entidade.PlanoAvulsoEntity
import org.game.api.data.entidade.PlanoEntity

class PlanoDAO(entityManager: EntityManager) :
    APIGamesDAO<PlanoDTO, PlanoEntity>(entityManager, PlanoEntity::class.java) {

    override fun toEntity(dto: PlanoDTO): PlanoEntity {
        return if (dto is PlanoAssinaturaDTO) {
            PlanoAssinaturaEntity(dto.tipo, dto.mensalidade, dto.jogosInclusos, dto.descontoReputacao, dto.id)
        } else {
            PlanoAvulsoEntity(dto.tipo, dto.id)
        }
    }

    override fun toDTO(entity: PlanoEntity): PlanoDTO {
        return if (entity is PlanoAssinaturaEntity) {
            PlanoAssinaturaDTO(entity.tipo, entity.mensalidade, entity.jogosIncluidos, entity.percentualDescontoReputacao)
        }else {
            PlanoAvulsoDTO(entity.tipo)
        }
    }
}
