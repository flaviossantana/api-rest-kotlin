package org.game.api.extensao

import org.game.api.data.entidade.GamerEntity
import org.game.api.data.modelo.Gamer

fun GamerEntity.toGamer():Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}
