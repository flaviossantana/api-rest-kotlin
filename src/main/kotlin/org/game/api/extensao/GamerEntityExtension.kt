package org.game.api.extensao

import org.game.api.data.entidade.GamerEntity
import org.game.api.data.dto.GamerDTO

fun GamerEntity.toGamer():GamerDTO {
    return GamerDTO(this.nome, this.email, this.dataNascimento, this.usuario, this.id)
}
