package org.game.api.extensao

import org.game.api.data.entidade.JogoEntity
import org.game.api.data.modelo.Jogo


fun JogoEntity.toJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao, this.id)
}

