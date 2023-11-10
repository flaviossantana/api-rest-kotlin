package org.game.api.data.modelo

import kotlin.random.Random

data class Gamer(var nome: String, var email: String) {
    var dataNascimento: String? = null
    var usuario: String? = null
    var idInterno: String? = null

    constructor(nome: String, email: String, dataNascimento: String, usuario: String) :
            this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        gerarIdentificador()
    }

    private fun gerarIdentificador() {
        val sequencial = Random.nextInt(10000)
        val tag = String.format("%04d", sequencial)

        this.idInterno = "$usuario#$tag"
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }
}
