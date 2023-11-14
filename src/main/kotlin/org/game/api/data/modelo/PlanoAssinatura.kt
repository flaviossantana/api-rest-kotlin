package org.game.api.data.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosInclusos: Int
) : Plano(tipo)
