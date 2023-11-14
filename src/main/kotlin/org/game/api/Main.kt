package org.game.api

import org.game.api.client.GameClient
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
            val jogoSharkAPI = GameClient().buscaJogo(idBusca)
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

            gamer.jogos.add(jogo)
        }

        resultado.onFailure {
            println("Erro ao buscar jogo: ${it.message}")
        }

        println("Deseja buscar um novo jogo? S/N ")
        val continuarPesquia = leitura.nextLine()



    } while (continuarPesquia.equals("S", true))

    println("nome=" +gamer.nome + ", email="+gamer.email+", dataNascimento="+gamer.dataNascimento+", usuario="+gamer.usuario+", idInterno=" + gamer.idInterno)

    gamer.jogos.sortBy {
        it?.titulo
    }

    gamer.jogos.forEach{
        println("Jogo: ${it?.titulo}")
    }

    val filtros = gamer.jogos.filter {
        it?.titulo?.contains("sonic", true) ?: false
    }

    filtros.forEach{
        println("Jogos do SONIC: ${it?.titulo}")
    }



    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("S", true)) {
        gamer.jogos.forEach{
            println("Jogo: ${it?.titulo}")
        }
        println("\n Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamer.jogos.removeAt(posicao)
        gamer.jogos.forEach{
            println("Jogo: ${it?.titulo}")
        }
    }



    println("Pesquisa realizada com scuesso!")
}
