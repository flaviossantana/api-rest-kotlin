package org.game.api.data.entidade

import jakarta.persistence.*

@Entity
@Table(name = "jogos")
class JogoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,
    val titulo: String = "",
    val capa: String = "",
    val preco: Double = 0.0,
    val descricao: String = ""
)

