package org.game.api.client

import com.google.gson.Gson
import org.game.api.data.api.JogoSharkAPI
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class CheapsharkClient {

    fun buscaJogo(idBusca: String): JogoSharkAPI {

        val path = "https://www.cheapshark.com/api/1.0/games?id=$idBusca"

        val httpClient: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(path))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        if (response.statusCode() == 404) {
            throw Exception("Jogo não encontrado")
        }


        val body = response.body()
        return Gson().fromJson(body, JogoSharkAPI::class.java)
    }

}
