package org.game.api.client

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.game.api.data.api.GamerInfoAPI
import org.game.api.data.modelo.Gamer
import org.game.api.extensao.toGamer
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GamerClient {

    fun buscaGamer(): List<Gamer> {

        val path = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val request = HttpRequest.newBuilder()
            .uri(URI.create(path))
            .build()

        val httpClient = HttpClient.newHttpClient()
        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        val body = response.body()
        val tipoGameInfro = object : TypeToken<List<GamerInfoAPI>>() {}.type
        val infoGamers: List<GamerInfoAPI> = Gson().fromJson(body, tipoGameInfro)

        return infoGamers.map { infoGamer ->
            infoGamer.toGamer()
        }
    }

}
