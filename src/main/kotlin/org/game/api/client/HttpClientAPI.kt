package org.game.api.client

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HttpClientAPI {

    companion object {
        fun enviar(path: String): String {

            val httpClient: HttpClient = HttpClient.newHttpClient()
            val request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .build()

            val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

            if (response.statusCode() == 404) {
                throw Exception("Não Encontrado!")
            }


            return response.body()
        }
    }
}
