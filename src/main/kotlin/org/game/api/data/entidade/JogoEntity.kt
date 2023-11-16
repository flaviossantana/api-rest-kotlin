package org.game.api.data.entidade

import jakarta.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    val titulo: String = "",
    val capa: String = "",
    val preco: Double = 0.0,
    val descricao :String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
)

