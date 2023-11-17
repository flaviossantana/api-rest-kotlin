package org.game.api.extensao

import org.game.api.data.api.GameSharkAPI
import org.game.api.data.dto.JogoDTO

fun GameSharkAPI.toJogo(): JogoDTO {
    return JogoDTO(this.info.title, this.info.thumb, this.info.cheapest)
}
