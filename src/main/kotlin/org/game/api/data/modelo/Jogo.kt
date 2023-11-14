package org.game.api.data.modelo

data class Jogo(val titulo: String, val capa: String, val preco: Double) {
    var descricao: String? = null


    override fun toString(): String {
        return "Jogo(titulo='$titulo', capa='$capa', descricao=$descricao, preco=$preco)"
    }
}
