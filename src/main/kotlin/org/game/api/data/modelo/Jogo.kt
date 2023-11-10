package org.game.api.data.modelo

data class Jogo(val titulo: String, val capa: String) {
    var descricao: String? = null

    override fun toString(): String {
        return "org.game.api.data.modelo.Jogo(titulo='$titulo', capa='$capa', descricao=$descricao)"
    }
}
