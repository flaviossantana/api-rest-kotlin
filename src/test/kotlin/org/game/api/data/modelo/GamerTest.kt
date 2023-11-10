package org.game.api.data.modelo


fun main() {
    val jogadorN1 = Gamer("Jao Jogador da Silva", "jjs@email.com")

    jogadorN1.let {
        it.usuario = "jjs_vicio"
    }

    println(jogadorN1)

    jogadorN1.let {
        it.usuario = "jjs_top"
    }

    println(jogadorN1)

    val jogadorN2 = Gamer(
        "Maria Jogadora da Silva",
        "mjs@email.com",
        "01/09/2010",
        "mariica"
    )

    jogadorN2.also {
        println(it)
    }

}



