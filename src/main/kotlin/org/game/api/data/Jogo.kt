package org.game.api.data

data class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = null

    override fun toString(): String {
        return "org.game.api.data.Jogo(titulo='$titulo', capa='$capa', descricao=$descricao)"
    }
}
