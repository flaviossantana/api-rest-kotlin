package org.game.api

import org.game.api.client.GameSharkClient
import org.game.api.data.dto.GamerDTO
import org.game.api.data.dto.JogoDTO
import java.util.*

fun main() {

    val leitura = Scanner(System.`in`)
    val gamerDTO = GamerDTO.criar(leitura)
    println("Cadastro realizado com sucesso: $gamerDTO ")

    do {

        println("Digite um código de jogo para buscar na API: ")
        val idBusca = leitura.nextLine()

        var jogoDTO: JogoDTO? = null
        val resultado = runCatching {
            jogoDTO = GameSharkClient().buscaJogo(idBusca)
            println(jogoDTO)
        }

        resultado.onSuccess {
            println("Deseja inserir uma descrição para o jogo pesquisado? S/N ")
            val opcao = leitura.nextLine()

            if (opcao.equals("S", true)) {
                println("Digite uma descrição para o jogo pesquisado: ")
                val descricao = leitura.nextLine()
                jogoDTO?.descricao = descricao
            } else {
                jogoDTO?.descricao = jogoDTO?.titulo
            }

            gamerDTO.pesquisados.add(jogoDTO)
        }

        resultado.onFailure {
            println("Erro ao buscar jogo: ${it.message}")
        }

        println("Deseja buscar um novo jogo? S/N ")
        val continuarPesquia = leitura.nextLine()



    } while (continuarPesquia.equals("S", true))

    println("nome=" +gamerDTO.nome + ", email="+gamerDTO.email+", dataNascimento="+gamerDTO.dataNascimento+", usuario="+gamerDTO.usuario+", idInterno=" + gamerDTO.idInterno)

    gamerDTO.pesquisados.sortBy {
        it?.titulo
    }

    gamerDTO.pesquisados.forEach{
        println("Jogo: ${it?.titulo}")
    }

    val filtros = gamerDTO.pesquisados.filter {
        it?.titulo?.contains("sonic", true) ?: false
    }

    filtros.forEach{
        println("Jogos do SONIC: ${it?.titulo}")
    }



    println("Deseja excluir algum jogo da lista original? S/N")
    val opcao = leitura.nextLine()
    if (opcao.equals("S", true)) {
        gamerDTO.pesquisados.forEach{
            println("Jogo: ${it?.titulo}")
        }
        println("\n Informe a posição do jogo que deseja excluir: ")
        val posicao = leitura.nextInt()
        gamerDTO.pesquisados.removeAt(posicao)
        gamerDTO.pesquisados.forEach{
            println("Jogo: ${it?.titulo}")
        }
    }



    println("Pesquisa realizada com scuesso!")
}
