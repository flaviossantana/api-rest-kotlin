package org.game.api.data.entidade

import jakarta.persistence.*

@Entity
@Table(name = "gamers")
open class GamerEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,
    val nome: String = "",
    val email: String = "",
    val dataNascimento:String? = null,
    val usuario:String? = null,
    @ManyToOne
    val plano: PlanoEntity = PlanoAvulsoEntity()) {
}
