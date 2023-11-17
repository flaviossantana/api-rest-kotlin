package org.game.api.data.entidade

import jakarta.persistence.*

@Entity
@Table(name = "planos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TipoPlano", discriminatorType = DiscriminatorType.STRING)
sealed class PlanoEntity(
    val tipo: String,
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0)

@Entity
@DiscriminatorValue("AVULSO")
open class PlanoAvulsoEntity(tipo: String): PlanoEntity(tipo)

@Entity
@DiscriminatorValue("ASSINATURA")
class PlanoAssinaturaEntity(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double): PlanoEntity(tipo)


