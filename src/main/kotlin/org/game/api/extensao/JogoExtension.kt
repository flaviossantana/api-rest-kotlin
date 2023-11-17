package org.game.api.extensao

import org.game.api.data.entidade.JogoEntity
import org.game.api.data.dto.JogoDTO

fun JogoDTO.toEntity(): JogoEntity{
    return JogoEntity(this.titulo, this.capa, this.preco, this.descricao)
}
