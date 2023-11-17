package org.game.api.data.entidade

sealed class PlanoEntity(val tipo: String)

class PlanoAvulsoEntity(tipo: String): PlanoEntity(tipo)

class PlanoAssinaturaEntity(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputacao: Double): PlanoEntity(tipo)


