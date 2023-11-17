package org.game.api.extensao

import org.game.api.data.api.GamerInfoAPI
import org.game.api.data.dto.GamerDTO

fun GamerInfoAPI.toGamer(): GamerDTO {
    return GamerDTO(this.nome, this.email, this.dataNascimento, this.usuario)
}
