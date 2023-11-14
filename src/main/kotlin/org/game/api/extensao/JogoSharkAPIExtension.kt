package org.game.api.extensao

import org.game.api.data.api.GameSharkAPI
import org.game.api.data.modelo.Jogo

fun GameSharkAPI.toJogo(): Jogo {
    return Jogo(this.info.title, this.info.thumb, this.info.cheapest)
}
