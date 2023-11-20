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
    var id: Int = 0)

@Entity
@DiscriminatorValue("AVULSO")
open class PlanoAvulsoEntity(
    tipo: String = "AVULSO",
    id: Int = 0
) : PlanoEntity(tipo, id)

@Entity
@DiscriminatorValue("ASSINATURA")
open class PlanoAssinaturaEntity(
    tipo: String = "ASSINATURA",
    val mensalidade: Double = 0.0,
    val jogosIncluidos: Int = 0,
    val percentualDescontoReputacao: Double = 0.0,
    id: Int = 0
) : PlanoEntity(tipo, id)


