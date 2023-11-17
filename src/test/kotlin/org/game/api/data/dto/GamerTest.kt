package org.game.api.data.dto

import com.google.gson.GsonBuilder
import org.game.api.client.GameHubClient
import org.game.api.client.GamerHubClient
import java.io.File
import java.time.LocalDate


fun main() {

    val jogadores = GamerHubClient().buscaGamer()
    val jogos = GameHubClient().buscaJogos()

    val jogadorN1 = jogadores[2]
    val jogadorN2 = jogadores[4]

    jogadorN1.recomendar(6)
    jogadorN1.recomendar(10)
    jogadorN1.recomendar(9)

    jogadorN1.planoDTO = PlanoAvulsoDTO("BRONZE")
    jogadorN1.alugar(jogos[1], LocalDate.now(), LocalDate.now().plusDays(3))
    jogadorN1.alugar(jogos[2], LocalDate.now(), LocalDate.now().plusDays(4))
    jogadorN1.alugar(jogos[3], LocalDate.now(), LocalDate.now().plusDays(20))
    jogadorN1.alugar(jogos[4], LocalDate.now(), LocalDate.now().plusDays(6))

    jogadorN1.avaliar(jogos[1], 8)
    jogadorN1.avaliar(jogos[2], 7)


    println(jogadorN1)

    jogadorN2.planoDTO = PlanoAssinaturaDTO("OURO", 59.90, 3, 0.15)

    jogadorN2.pesquisados.add(jogos[5])
    jogadorN2.pesquisados.add(jogos[6])
    jogadorN2.pesquisados.add(jogos[7])
    jogadorN2.pesquisados.add(jogos[8])

    jogadorN2.recomendar(10)
    jogadorN1.avaliar(jogos[5], 10)
    jogadorN1.avaliar(jogos[7], 6)

    jogadorN2.alugar(jogadorN2.pesquisados[0] ?: jogos[5], LocalDate.now(), LocalDate.now().plusDays(30))
    jogadorN2.alugar(jogadorN2.pesquisados[1] ?: jogos[6], LocalDate.now(), LocalDate.now().plusDays(60))
    jogadorN2.alugar(jogadorN2.pesquisados[2] ?: jogos[7], LocalDate.now(), LocalDate.now().plusDays(90))
    jogadorN2.alugar(jogadorN2.pesquisados[3] ?: jogos[8], LocalDate.now(), LocalDate.now().plusDays(90))

    println(jogadorN2)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val recomendacoes = gson.toJson(jogadorN1.recomendados)

    println(recomendacoes)

    val arquivoRecomendacao = File("${jogadorN1.idInterno}_recomendacoes.json")
    arquivoRecomendacao.writeText(recomendacoes)
    println(arquivoRecomendacao.absoluteFile)


}




