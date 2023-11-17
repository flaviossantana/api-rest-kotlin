package org.game.api.extensao

import org.game.api.data.api.GameHubAPI
import org.game.api.data.dto.JogoDTO

fun GameHubAPI.toJogo(): JogoDTO {
    return JogoDTO(this.titulo, this.capa, this.preco)
}
