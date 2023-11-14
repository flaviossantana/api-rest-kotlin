package org.game.api.extensao

import org.game.api.data.api.GameHubAPI
import org.game.api.data.modelo.Jogo

fun GameHubAPI.toJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco)
}
