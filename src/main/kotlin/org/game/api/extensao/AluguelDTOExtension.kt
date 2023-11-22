package org.game.api.extensao

import org.game.api.data.dto.AluguelDTO
import org.game.api.data.entidade.AluguelEntity

fun AluguelDTO.toEnttity(): AluguelEntity {
    return AluguelEntity(
        this.gamerDTO.toEntity(),
        this.jogoDTO.toEntity(),
        this.periodo)
}
