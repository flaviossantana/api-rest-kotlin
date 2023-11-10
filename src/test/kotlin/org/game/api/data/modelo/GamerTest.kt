package org.game.api.data.modelo


fun main() {
    val jogadorN1 = Gamer("Jao Jogador da Silva", "jjs@email.com")

    val jogadorN2 = Gamer(
        "Maria Jogadora da Silva",
        "mjs@email.com",
        "01/09/2010",
        "ID:12103546804651890"
    )

    println(jogadorN1)
    println(jogadorN2)

    jogadorN1.let {
        it.usuario = "jjs_vicio"
        it.idInterno = "ID:7112080808000"
    }

    println(jogadorN1)
}



