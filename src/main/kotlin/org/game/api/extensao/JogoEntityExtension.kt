package org.game.api.extensao

import org.game.api.data.entidade.JogoEntity
import org.game.api.data.dto.JogoDTO


fun JogoEntity.toJogo(): JogoDTO {
    return JogoDTO(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

