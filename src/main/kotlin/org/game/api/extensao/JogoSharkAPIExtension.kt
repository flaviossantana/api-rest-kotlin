package org.game.api.extensao

import org.game.api.data.api.JogoSharkAPI
import org.game.api.data.modelo.Jogo

fun JogoSharkAPI.toJogo(): Jogo {
    return Jogo(this.info.title, this.info.thumb)
}
