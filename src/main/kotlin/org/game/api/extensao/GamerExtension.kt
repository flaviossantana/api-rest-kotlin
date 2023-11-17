package org.game.api.extensao

import org.game.api.data.entidade.GamerEntity
import org.game.api.data.modelo.Gamer

fun Gamer.toEntity():GamerEntity {
    return GamerEntity(this.id, this.nome, this.email, this.dataNascimento, this.usuario)
}
