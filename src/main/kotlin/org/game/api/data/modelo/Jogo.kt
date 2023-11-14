package org.game.api.data.modelo

import com.google.gson.annotations.Expose
import org.game.api.data.contrato.Recomendavel

data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String,
    val preco: Double): Recomendavel {
    var descricao: String? = null
    private val notas = mutableListOf<Int>()
    override val media: Double
        get() = notas.average()

    override fun recomendar(nota: Int) {
        notas.add(nota)
    }

    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao=$descricao, preco=$preco)"
    }
}
