package org.game.api.data.entidade

import jakarta.persistence.*
import org.game.api.data.dto.PeriodoDTO

@Entity
@Table(name = "aluguel")
class AluguelEntity(
    @ManyToOne
    val gamer: GamerEntity = GamerEntity(),
    @ManyToOne
    val jogo: JogoEntity = JogoEntity(),
    @Embedded
    val periodo: PeriodoDTO = PeriodoDTO()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Int = 0
    var valor = 0.0
}
