package org.game.api.extensao

import org.game.api.data.api.GamerInfoAPI
import org.game.api.data.modelo.Gamer

fun GamerInfoAPI.toGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}
