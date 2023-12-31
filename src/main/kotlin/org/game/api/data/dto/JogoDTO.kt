package org.game.api.data.dto

import com.google.gson.annotations.Expose
import org.game.api.data.contrato.Recomendavel


data class JogoDTO(
    @Expose val titulo: String,
    @Expose val capa: String
) : Recomendavel {
    var id = 0
    var preco = 0.0
    var descricao: String? = null
    private val notas = mutableListOf<Int>()
    override val media: Double
        get() = notas.average()

    constructor(titulo: String, capa: String, preco: Double) : this(titulo, capa) {
        this.preco = preco
    }

    constructor(titulo: String, capa: String, preco: Double, descricao: String?, id: Int = 0) : this(titulo, capa) {
        this.preco = preco
        this.descricao = descricao
        this.id = id
    }

    override fun recomendar(nota: Int) {
        notas.add(nota)
    }

    override fun toString(): String {
        return "\nJogo(\n titulo='$titulo',\n capa='$capa',\n descricao=$descricao,\n preco=$preco)"
    }
}
