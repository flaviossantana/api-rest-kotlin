package org.game.api.dao

import jakarta.persistence.EntityManager
import org.game.api.data.dto.JogoDTO
import org.game.api.extensao.toEntity

class JogoDAO(entityManager: EntityManager): APIGamesDAO<JogoDTO>(entityManager) {

    override fun toEntity(objeto: JogoDTO) {
        objeto.toEntity()
    }

    override fun todos(): List<JogoDTO> {
        TODO("Not yet implemented")
    }

}
