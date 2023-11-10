package org.game.api

import org.game.api.client.CheapsharkClient
import org.game.api.data.modelo.Jogo
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)

    println("Digite um código de jogo para buscar na API: ")
    val idBusca = leitura.nextLine()

    var jogo: Jogo? = null
    val resultado = runCatching {

        val jogoSharkAPI = CheapsharkClient().buscaJogo(idBusca)
        println(jogoSharkAPI)

        jogo = Jogo(jogoSharkAPI.info.title, jogoSharkAPI.info.thumb)
        println(jogo)
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição para o jogo pesquisado? S/N ")
        val opcao = leitura.nextLine()

        if (opcao.equals("S", true)) {
            println("Digite uma descrição para o jogo pesquisado: ")
            val descricao = leitura.nextLine()
            jogo?.descricao = descricao
        } else {
            jogo?.descricao = jogo?.titulo
        }
    }

    resultado.onSuccess {
        println("Pesquisa realizada com scuesso: $jogo")
    }

    resultado.onFailure {
        println("Erro ao buscar jogo: ${it.message}")
    }

}
