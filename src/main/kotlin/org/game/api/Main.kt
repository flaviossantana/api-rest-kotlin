package org.game.api

import org.game.api.client.CheapsharkClient
import org.game.api.data.modelo.Gamer
import org.game.api.data.modelo.Jogo
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    val gamer = Gamer.criar(leitura)
    println("Cadastro realizado com sucesso: $gamer ")

    do {

        println("Digite um código de jogo para buscar na API: ")
        val idBusca = leitura.nextLine()

        var jogo: Jogo? = null
        val resultado = runCatching {
            val jogoSharkAPI = CheapsharkClient().buscaJogo(idBusca)
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

        resultado.onFailure {
            println("Erro ao buscar jogo: ${it.message}")
        }

        println("Deseja buscar um novo jogo? S/N ")
        val continuarPesquia = leitura.nextLine()

        gamer.jogos.add(jogo)

    } while (continuarPesquia.equals("S", true))

    println(gamer)
    println("Pesquisa realizada com scuesso!")
}
