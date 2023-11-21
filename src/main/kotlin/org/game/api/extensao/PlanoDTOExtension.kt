package org.game.api.extensao

import org.game.api.data.dto.PlanoAssinaturaDTO
import org.game.api.data.dto.PlanoDTO
import org.game.api.data.entidade.PlanoAssinaturaEntity
import org.game.api.data.entidade.PlanoAvulsoEntity
import org.game.api.data.entidade.PlanoEntity

fun PlanoDTO.toEntity(): PlanoEntity {
    return if (this is PlanoAssinaturaDTO) {
        PlanoAssinaturaEntity(this.tipo, this.mensalidade, this.jogosInclusos, this.descontoReputacao, this.id)
    } else {
        PlanoAvulsoEntity(this.tipo, this.id)
    }
}
