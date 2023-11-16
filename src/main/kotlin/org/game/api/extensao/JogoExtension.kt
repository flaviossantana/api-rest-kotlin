package org.game.api.extensao

import org.game.api.data.entidade.JogoEntity
import org.game.api.data.modelo.Jogo

fun Jogo.toEntity(): JogoEntity{
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao)
}
