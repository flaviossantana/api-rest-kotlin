package org.game.api.extensao

import org.game.api.data.dto.PlanoAssinaturaDTO
import org.game.api.data.dto.PlanoAvulsoDTO
import org.game.api.data.dto.PlanoDTO
import org.game.api.data.entidade.PlanoAssinaturaEntity
import org.game.api.data.entidade.PlanoEntity

fun PlanoEntity.toDTO(): PlanoDTO {
    return if (this is PlanoAssinaturaEntity) {
        PlanoAssinaturaDTO(this.tipo, this.mensalidade, this.jogosIncluidos, this.percentualDescontoReputacao)
    }else {
        PlanoAvulsoDTO(this.tipo)
    }
}
