package org.game.api.extensao

import org.game.api.data.dto.AluguelDTO
import org.game.api.data.entidade.AluguelEntity

fun AluguelEntity.toAluguel():AluguelDTO{
    return AluguelDTO(this.gamer.toGamer(), this.jogo.toJogo(), this.periodo)
}
